//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int n = x.length();
        int m = y.length();
        int prev[] = new int[m+1];
        for(int j=1;j<=m;j++){
            prev[j] = costY * j;
        }
        
        for(int i=1;i<=n;i++){
            int curr[] = new int[m+1];
            curr[0] = costX  * i;
            for(int j=1;j<=m;j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
                    curr[j] = Math.min( costX + prev[j] , costY + curr[j-1] );
                }
            }
            prev = curr;
        }
        
        return prev[m];
    }
}
