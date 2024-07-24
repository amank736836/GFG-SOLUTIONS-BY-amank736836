//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    private int timer = 0;
    //Function to return Breadth First Traversal of given graph.
    private void dfs(int child,int parent,boolean visited[],int insertionTime[]
    ,int lowInsertionTime[],boolean mark[],ArrayList<ArrayList<Integer>> adj){
        visited[child] = true;
        insertionTime[child] = timer;
        lowInsertionTime[child] = timer;
        timer++;
        int children = 0;
        for(int subChild : adj.get(child)){
            if(subChild == parent){
                continue;
            }
            if(visited[subChild]){
                lowInsertionTime[child] = Math.min(lowInsertionTime[child] , insertionTime[subChild]);
            }else{
                dfs(subChild,child,visited,insertionTime,lowInsertionTime,mark,adj);
                lowInsertionTime[child] = Math.min(lowInsertionTime[child] , lowInsertionTime[subChild]);
                if(lowInsertionTime[subChild] >= insertionTime[child] && parent != -1){
                    mark[child] = true;
                }
                children++;
            }
        }
        if(children > 1 && parent == -1){
            mark[child] = true;
        }
        
    }
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean visited[] = new boolean[V];
        int insertionTime[] = new int[V];
        int lowInsertionTime[] = new int[V];
        boolean mark[] = new boolean[V];
        
        dfs(0,-1,visited,insertionTime,lowInsertionTime,mark,adj);
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(mark[i]){
               ans.add(i); 
            }
        }
        
        if(ans.size() == 0){
            ans.add(-1);
        }
        
        return ans;
    }
}