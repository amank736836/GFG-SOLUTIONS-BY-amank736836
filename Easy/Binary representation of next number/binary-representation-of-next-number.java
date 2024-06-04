//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        // code here.
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        int n = str.length();
        char carry = '1';
        for(int i=0;i<n && carry == '1';i++){
            if(str.charAt(i) == '0'){
                str.setCharAt(i,'1');
                carry = '0';
            }
            else{
                str.setCharAt(i,'0');
                carry = '1';
            }
        }
        if(carry == '1'){
            str.append('1');
            n++;
        }

        str.reverse();
        
        int idx = 0;
        while(str.charAt(idx) == '0'){
            idx++;
        }
        
        return str.substring(idx , n);
    }
}