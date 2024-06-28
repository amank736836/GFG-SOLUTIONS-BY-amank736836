//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public String pattern(int[][] arr) {
        // Code here
        for(int i=0;i<arr.length;i++){
            if(isRowPalindrome(arr,i) == true){
                return i + " " + "R";
            }
        }
        for(int j=0;j<arr.length;j++){
            if(isColPalindrome(arr,j) == true){
                return j + " " + "C";
            }
        }
        return "-1";
    }
    
    public boolean isRowPalindrome(int arr[][],int i){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            if(arr[i][start] == arr[i][end]){
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
    
    public boolean isColPalindrome(int arr[][],int j){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            if(arr[start][j] == arr[end][j]){
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
    
    
}
