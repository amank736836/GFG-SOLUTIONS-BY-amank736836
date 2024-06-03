//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static long sequence(int n){
        // code here
        long ans = 0;
        int x = 1;
        for(int i=1;i<=n;i++){
            long subAns = 1;
            for(int j=0;j<i;j++){
                subAns *= x;
                x++;
                subAns %= 1000000007;
            }
            ans += subAns;
            ans %= 1000000007;
            //System.out.println(ans);
        }
        return ans;
    }
}