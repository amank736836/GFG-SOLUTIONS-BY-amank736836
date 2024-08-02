//{ Driver Code Starts


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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        // code here
        boolean primes[] = new boolean[N+1];
        for(int i=2;i<=N/2;i++){
            if(primes[i] == false){
                for(int x = i*2;x<=N;x+=i){
                    primes[x] = true;
                }
            }
        }
        
        List<Integer> factors = new ArrayList<>();
        for(int i=2;i <= N;i++){
            if(primes[i] == false && N % i == 0){
                factors.add(i);
            }
        }
        
        int ans[] = new int[factors.size()];
        if(factors.size() == 0 && N > 1){
            ans = new int[]{N};
        }
        int i = 0;
        for(int factor : factors){
            ans[i++] = factor;
        }
        return ans;
    }
}