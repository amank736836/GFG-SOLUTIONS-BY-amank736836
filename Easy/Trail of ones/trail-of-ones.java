//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static long power(long a,long b){
        int MOD = (int)1e9 + 7;
        long ans = 1;
        
        while(b>0){
            if((b & 1) == 1){
                ans *= a;
                ans %= MOD;
            }
            a *= a;
            a %= MOD;
            b >>= 1;
        }
        
        return ans;
    }
    
    static int numberOfConsecutiveOnes(int n) {
        // code here
        int MOD = (int)1e9 + 7;
        
        if(n==0){
            return 0;
        }
        
        int a[] = new int[n];
        int b[] = new int[n];
        
        a[0] = 1;
        b[0] = 1;
        
        for(int i=1;i<n;i++){
            a[i] = (a[i-1] + b[i-1]) % MOD;
            b[i] = a[i-1];
        }
        
        long totalBinaryStrings = power(2,n);
        long validStrings = (a[n-1] + b[n-1]) % MOD;
        
        return (int) ((totalBinaryStrings - validStrings + MOD) % MOD );
        
    }
}
