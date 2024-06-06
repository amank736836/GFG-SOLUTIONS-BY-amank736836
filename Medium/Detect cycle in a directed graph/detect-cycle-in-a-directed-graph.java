//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        //System.out.println(adj);
        int visited[] = new int[V];
        int pathVisited[] = new int[V];
        int n = adj.size();
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                if(dfs(i,visited,pathVisited,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i,int visited[],int[] pathVisited,ArrayList<ArrayList<Integer>> adj){
        visited[i] = 1;
        pathVisited[i] = 1;
        for(int val : adj.get(i)){
            if(visited[val] == 0){
                if(dfs(val,visited,pathVisited,adj)){
                    return true;
                }
            }else if(pathVisited[val] == 1){
                return true;
            }
        }
        pathVisited[i] = 0;
        return false;
    }
}