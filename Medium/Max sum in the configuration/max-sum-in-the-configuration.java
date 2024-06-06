//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        // Your code here
        long sum = 0;
        long initial = 0;
        
        for(int i=0;i<n;i++){
            sum += a[i];
            initial += (long) i * a[i];
        }
        
        long ans = initial;
        
        for(int i=1;i<n;i++){
            initial = initial  - (sum-a[i-1]) + (long)(n-1)*a[i-1];
            if(ans < initial){
                ans = initial;
            }
        }
        
        return ans;
    }
}
