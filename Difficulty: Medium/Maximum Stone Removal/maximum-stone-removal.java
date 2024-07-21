//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class DisjointSet{
    int parent[];
    int rank[];
    int size[];
    
    public DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }
        
    public int findUltimateParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findUltimateParent(parent[node]);
    }
    
    public void unionByRank(int u,int v){
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
        }
        else{
            parent[ultimateParentU] = ultimateParentV;
            rank[ultimateParentV]++;
        }
    }
    
    public void unionBySize(int u,int v){
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        
        if(ultimateParentU == ultimateParentV){
            return;
        }
        if(size[ultimateParentU] < size[ultimateParentV]){
            parent[ultimateParentU] = ultimateParentV;
            size[ultimateParentV] += size[ultimateParentU];
        }else{
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU] += size[ultimateParentV];
        }
    }
    
}

class Solution {

    int maxRemove(int[][] stones, int n) {
        // Code here
        int maxRow = 0;
        int maxCol = 0;
        for(int stone[] : stones){
            maxRow = Math.max(maxRow , stone[0]);
            maxCol = Math.max(maxCol , stone[1]);
        }
        
        DisjointSet djs = new DisjointSet(maxRow + maxCol + 2);
        
        HashMap<Integer,Integer> stoneNodes = new HashMap<>();
        
        for(int stone[] : stones){
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            djs.unionBySize(nodeRow , nodeCol);
            stoneNodes.put(nodeRow , 1);
            stoneNodes.put(nodeCol , 1);
        }
        
        int cnt = 0;
        for(Map.Entry<Integer,Integer> stone : stoneNodes.entrySet()){
            if(djs.findUltimateParent(stone.getKey()) == stone.getKey()){
                cnt++;
            }
        }
        
        return n - cnt;
        
    }
};
