//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class DisjointSet{
    
    int parent[];
    int size[];
    int rank[];
    
    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
    }
    
    int findUltimateParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findUltimateParent(parent[node]);
    }
    
    void unionByRank(int u,int v){
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if(ultimateParentU == ultimateParentV){
            return;
        }
        if(rank[ultimateParentU] < rank[ultimateParentV]){
            parent[ultimateParentU] = ultimateParentV;
        }
        else if(rank[ultimateParentV] < rank[ultimateParentU]){
            parent[ultimateParentV] = ultimateParentU;
        }else{
            parent[ultimateParentU] = ultimateParentV;
            rank[ultimateParentU] += 1;
        }
    }
    
    void unionBySize(int u,int v){
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if(ultimateParentU == ultimateParentV){
            return;
        }
        if(size[ultimateParentU] < size[ultimateParentV]){
            parent[ultimateParentU] = ultimateParentV;
        }
        else{
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU] += size[ultimateParentV];
        }
    }
    
}


class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int deletedRow[] = {-1,0,1,0};
        int deletedCol[] = {0,1,0,-1};
        boolean visited[][] = new boolean[rows][cols];
        int components = 0;
        List<Integer> ans = new ArrayList<>();
        DisjointSet djs = new DisjointSet(rows*cols);
        for(int i=0;i<operators.length;i++){
            int row = operators[i][0];
            int col = operators[i][1];
            if(visited[row][col]){
                ans.add(components);
            }else{
                visited[row][col] = true;
                components++;
                for(int j=0;j<4;j++){
                    int newRow = row + deletedRow[j];
                    int newCol = col + deletedCol[j];
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols){
                        if(visited[newRow][newCol]){
                            int node = row * cols + col;
                            int adjNode = newRow * cols + newCol;
                            if(djs.findUltimateParent(node) != djs.findUltimateParent(adjNode)){
                                components--;
                                djs.unionBySize(node,adjNode);
                            }
                        }
                    }
                }
                ans.add(components);
            }
        }
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends