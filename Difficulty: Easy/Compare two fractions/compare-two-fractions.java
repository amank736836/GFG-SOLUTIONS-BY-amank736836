//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        String a = str.substring(0,str.indexOf("/"));
        String b = str.substring(str.indexOf("/")+1 , str.indexOf(","));
        String c = str.substring(str.indexOf(",")+2 , str.indexOf("/",str.indexOf(",")+2));
        String d = str.substring(str.indexOf("/",str.indexOf(",")+2)+1);
        
        double k = Integer.valueOf(a) / (double) Integer.valueOf(b);
        double m = Integer.valueOf(c) / (double) Integer.valueOf(d);
        
        String ans = (k>m) ? (a+"/"+b) : (k<m) ? (c + "/" + d) : "equal";
        
        return ans;
    }
}
