//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSub(a, n) ? 1:0);
            
        }
	}
}


// } Driver Code Ends




//User function Template for Java


class Solution {
    
    public boolean countSub(long a[], long n)
    {
        // Your code goes here
        int i = 0;
        while((2*i+1)<n){
            if(a[i]>=a[2*i+1]){
                if(2*i+2<n && a[i]<a[2*i+2]){
                    return false;
                }
                i++;
            }else{
                return false;
            }
        }
        return true;
    }
}