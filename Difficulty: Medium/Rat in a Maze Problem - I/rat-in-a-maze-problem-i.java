//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.length;
        if(mat[0][0] == 0 || mat[n-1][n-1] == 0){
            return ans;
        }
        boolean visited[][] = new boolean[n][n];
        recursion(0,0,mat,visited,n,"",ans);
        return ans;
    }
    
    public void recursion(int i,int j,int mat[][],boolean visited[][],int n,String str,ArrayList<String> ans){
        if(i == n-1 && j == n-1){
            ans.add(str);
            return;
        }
        
        visited[i][j] = true;
        
        if(i+1 < mat.length && mat[i+1][j] == 1 && visited[i+1][j] == false){
            recursion(i+1,j,mat,visited,n,str+"D",ans);
        }
        if(j+1 < mat.length && mat[i][j+1] == 1 && visited[i][j+1] == false){
            recursion(i,j+1,mat,visited,n,str+"R",ans);
        }
        if(i-1 >= 0 && mat[i-1][j] == 1 && visited[i-1][j] == false){
            recursion(i-1,j,mat,visited,n,str+"U",ans);
        }
        if(j-1 >= 0 && mat[i][j-1] == 1 && visited[i][j-1] == false){
            recursion(i,j-1,mat,visited,n,str+"L",ans);
        }
        
        visited[i][j] = false;
        
    }
}