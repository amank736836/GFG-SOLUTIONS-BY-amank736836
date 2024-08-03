//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        for(int hero=0;hero<n;hero++){
            int heKnow = 0;
            for(int column = 0;column < n;column++){
                heKnow += mat[hero][column];
            }
            
            int othersKnow = 0;
            for(int row = 0;row < n;row++){
                othersKnow += mat[row][hero];
            }
            
            if(heKnow == 0 && othersKnow == n-1){
                return hero;
            }
        }
        return -1;
    }
}