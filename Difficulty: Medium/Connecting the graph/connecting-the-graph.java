//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        int total = edge.length;
        if(total < n-1){
            return -1;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<total;i++){
            int u = edge[i][0];
            int v = edge[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean visited[] = new boolean[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
                dfs(visited,i,adj);
            }
        }
        
        return cnt - 1;
    }
    
    private void dfs(boolean visited[],int node,ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(visited,i,adj);
            }
        }
    }
}