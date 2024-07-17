//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class DisjointSet{
    int parent[];
    int rank[];
    int size[];
    
    public DisjointSet(int N){
        parent = new int[N+1];
        rank = new int[N+1];
        size = new int[N+1];
        
        for(int i=0;i<N;i++){
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }
    
    int findParent(int U){
        if(U == parent[U]){
            return U;
        }
        return parent[U] = findParent(parent[U]);
    }
    
    void unionByRank(int U,int V){
        int parentU = findParent(parent[U]);
        int parentV = findParent(parent[V]);
        
        if(parentU != parentV){
            if(rank[parentU] < rank[parentV]){
                parent[U] = parentV;
            }
            else if(rank[parentU] > rank[parentV]){
                parent[V] = parentU;
            }
            else{
                parent[U] = parentV;
                rank[parentV] = rank[parentV] + 1;
            }
        }
    }
    
    void unionBySize(int U, int V){
        int parentU = findParent(U);
        int parentV = findParent(V);
        
        if(parentU != parentV){
            if(size[parentU] < size[parentV]){
                parent[parentU] = parentV;
                size[parentV] += size[parentU];
            }
            else{
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            }
        }
    }
    
}


class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet djs = new DisjointSet(V);
        for(int i = 0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j) == 1){
                    djs.unionBySize(i,j);
                }
            }
        }
        
        int count = 0;
        
        for(int i=0;i<V;i++){
            if(djs.findParent(i) == i){
                count++;
            }
        }
        
        return count;
    }
};