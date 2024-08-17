//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        long ans[] = new long[n];
        int zero = 0;
        long multiple = 1;
        for(int num : nums){
            if(num == 0){
                zero++;
            }else{
                multiple *= num;
            }
        }
        if(zero >= 2){
            return ans;
        }else{
            for(int i=0;i<n;i++){
                if(zero == 0){
                    ans[i] = multiple / nums[i];
                }else if(nums[i] == 0){
                    ans[i] = multiple;
                }
            }
        }
        return ans;
        
    }
}
