//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int columnStart = 0;
        int columnEnd = matrix.length-1;
        int rowStart = 0;
        int rowEnd = matrix[0].length-1;
        while(rowStart <= rowEnd && columnStart <= columnEnd){
            for(int i = rowStart;i<=rowEnd;i++){
                result.add(matrix[columnStart][i]);
            }
            columnStart++;
            
            for(int i = columnStart;i <= columnEnd;i++){
                result.add(matrix[i][rowEnd]);
            }
            rowEnd--;
            
            if(columnStart <= columnEnd){
                for(int i = rowEnd;i >= rowStart;i--){
                    result.add(matrix[columnEnd][i]);
                }
                columnEnd--;
            }
            if(rowStart <= rowEnd){
                for(int i = columnEnd;i>=columnStart;i--){
                    result.add(matrix[i][rowStart]);
                }
                rowStart++;
            }
        }
        
        return result;
    }
}
