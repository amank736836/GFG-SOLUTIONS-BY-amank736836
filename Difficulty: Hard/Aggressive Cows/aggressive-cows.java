//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    public static boolean check(int mid,int stalls[],int k){
        int cows = 1;
        int last = stalls[0];
        for(int stall : stalls){
            if(stall - last >= mid){
                last = stall;
                cows++;
            }
            if(cows == k){
                return true;
            }
        }
        return false;
    }
    
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int start = 1;
        int end = stalls[n-1] - stalls[0];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(mid,stalls,k)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
        
    }
}