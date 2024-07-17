//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    
    public void unionByRank(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v){
            return;
        }
        
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_u,ulp_v);
            rank.set(ulp_v,rank.get(ulp_v)+1);
        }
    }
    
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        DisjointSet djs = new DisjointSet(V);
        List<int[]> list = new ArrayList<>();
        int result = 0;
        for(int src=0;src<V;src++){
            for(int row[] : adj.get(src)){
                int dest = row[0];
                int weight = row[1];
                list.add(new int[]{src,dest,weight});
            }
        }
        
        Collections.sort(list, (a,b) -> a[2] - b[2]);
        
        for(int ele[] : list){
            int p_u = djs.findParent(ele[0]);
            int p_v = djs.findParent(ele[1]);
            
            if(p_u == p_v){
                continue;
            }
            
            result += ele[2];
            djs.unionBySize(ele[0],ele[1]);
        }
        
        return result;
    }
}