//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {
    }
    static int []primes;
    static void sieve(int n){
        primes = new int[n+1];
        for(int i = 2;i*i<=n;i++){
            if(primes[i] == 0){
                for(int j = i * i;j<=n;j+=i){
                    if(primes[j] == 0){
                        primes[j] = i;
                    }
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        // code here
        sieve(N);
        List<Integer> ans = new ArrayList<>();
        while(N > 1){
            if(primes[N] == 0){
                ans.add(N);
                N = 1;
            }else{
                ans.add(primes[N]);
                N /= primes[N];
            }
        }
        return ans;
    }
}
