//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int dp[][] = new int[n+1][w+1];
        int ans = solve(0,cost,w,dp);
        if(ans >= 1e9){
            ans = -1;
        }
        return ans;
    }
    
    public static int solve(int index,int[] cost,int w,int[][] dp){
        if(w==0){
            return 0;
        }
        if(index == cost.length || index+1 > w){
            return (int)1e9;
        }
        if(dp[index][w] != 0){
            return dp[index][w];
        }
        int a = (int) 1e9;
        int b = solve(index+1,cost,w,dp);
        if(cost[index] != -1){
            a = cost[index] + solve(index , cost , w-(index+1) , dp);
        }
        
        return dp[index][w] = Math.min(a,b);
    }
}
