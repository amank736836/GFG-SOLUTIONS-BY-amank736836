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
    static List<Boolean> primes = new ArrayList<>();
    static void sieve(int n){
        int x = primes.size();
        for(int i = x;i<=n;i++){
            primes.add(true);
        }
        if(x == 0){
            x = 2;
            primes.set(0,false);
            primes.set(1,false);
        }
        for(int i = x;i<=n;i++){
            if(primes.get(i)){
                for(int j = i + i;j<=n;j+=i){
                    primes.set(j,false);
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        // code here
        sieve(N);
        List<Integer> ans = new ArrayList<>();
        int i = 2;
        while(i <= N){
            if(N % i == 0 && primes.get(i)){
                ans.add(i);
                N /= i;
            }else{
                i++;
            }
            
        }
        return ans;
    }
}
