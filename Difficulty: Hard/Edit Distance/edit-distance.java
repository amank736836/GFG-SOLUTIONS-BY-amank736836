//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
        int dp[][] = new int[str1.length()][str2.length()];
        return minOperations(str1.length()-1,str2.length()-1,str1,str2,dp);
    }
    
    public int minOperations(int i,int j,String str1,String str2,int dp[][]){
        if(i < 0 && j < 0 ){
            return 0;
        }
        else if(i < 0 && j >= 0){
            return j+1;
        }
        else if(i >= 0 && j < 0){
            return i+1;
        }
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = minOperations(i-1,j-1,str1,str2,dp);
        }
        else{
            int min = Integer.MAX_VALUE;
            int min1 = minOperations(i,j-1,str1,str2,dp); // insert
            int min2 = minOperations(i-1,j-1,str1,str2,dp); // replace
            int min3 = minOperations(i-1,j,str1,str2,dp); // remove
            min = Math.min(min1,min2);
            min = Math.min(min,min3);
            return dp[i][j] = min + 1;
        }
        
    }
}