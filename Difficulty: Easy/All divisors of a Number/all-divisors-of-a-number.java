//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            obj.print_divisors(n);
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static void print_divisors(int n) {
        // code here
        List<Integer> divisors = new ArrayList<>();
        for(int i=1;i*i <= n;i++){
            if(n%i == 0){
                divisors.add(i);
                if(n/i != i){
                    divisors.add(n/i);
                }
            }
        }
        
        Collections.sort(divisors);
        
        for(int num : divisors){
            System.out.print(num + " ");
        }
        
    }
}
