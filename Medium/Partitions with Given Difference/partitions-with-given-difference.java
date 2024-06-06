//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int total = 0;
        for(int num : arr){
            total += num;
        }
        
        if(total-d < 0 || (total-d)%2 != 0){
            return 0;
        }
        
        int target = (total - d) / 2;
        
        int[] prev = new int[target+1];
        prev[0] = 1;
        
        int MOD = (int) 1e9 + 7;
        
        for(int i=1;i<=n;i++){
            for(int j=target;j>=arr[i-1];j--){
                prev[j] = (prev[j] + prev[j-arr[i-1]]) % MOD;
            }
        }
        
        return prev[target];
    }
}
        
