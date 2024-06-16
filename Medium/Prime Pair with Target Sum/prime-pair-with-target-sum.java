//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j = i * i;j <= n;j += i){
                    isPrime[j] = false;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<=n/2;i++){
            int j = n-i;
            if(isPrime[i] && isPrime[j]){
                ans.add(i);
                ans.add(j);
                return ans;
            }
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
        
    }
}
