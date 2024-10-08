//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        int count = 0;
        int n = str.length();
        int i = 0;
        while(i < n){
            int j = i;
            String s = "";
            while(j<n && str.charAt(j) != '.'){
                s += str.charAt(j);
                j++;
            }
            int val = Integer.parseInt(s);
            if(val < 0 || val > 255 || count == 4){
                return false;
            }
            else{
                count++;
            }
            i = j + 1;
        }
        return count == 4;
    }
}