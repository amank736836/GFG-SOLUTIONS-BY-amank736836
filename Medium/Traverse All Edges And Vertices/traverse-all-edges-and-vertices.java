//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] paths = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    paths[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.isPossible(paths);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int isPossible(int[][] paths)
    {
        // Code here
        boolean f = true;
        for(int i =0 ;i<paths.length;i++){
            int cnt = 0;
            for(int j=0;j<paths[i].length;j++){
                cnt += paths[i][j] == 1 ? 1 : 0;
            }
            if((cnt&1) != 0 || cnt == 0){
                f = false;
            }
        }
        
        if(paths.length == 1){
            return 1;
        }
        return f ? 1 : 0;
        
    }
}