//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        long ans = -1;
        long curr = 0;
        int i=0;
        int n = sentence.length();
        while(i<n){
            curr = 0;
            boolean flag = true;
            while(i<n && sentence.charAt(i) != ' '){
                if(flag && sentence.charAt(i) >= '0' && sentence.charAt(i) <= '8'){
                    curr = curr * 10 + (sentence.charAt(i) - '0');
                }
                else{
                    flag = false;
                }
                i++;
            }
            i++;
            if(flag){
                ans = Math.max(ans , curr);
            }
        }
        return ans;
    }
}