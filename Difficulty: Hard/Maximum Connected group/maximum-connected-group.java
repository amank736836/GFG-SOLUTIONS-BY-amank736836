//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid.length;
        Map<Integer,Integer> compToCount = new HashMap<>();
        int id = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int count = dfs(grid,i,j,id);
                    compToCount.put(id,count);
                    id++;
                }
            }
        }
        
        int maxCnt = grid[0][0] == 0 ? 1 : compToCount.get(grid[0][0]);
        Set<Integer> set = new HashSet<>(4);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    int cnt = 1;
                    for(int dir[] : directions){
                        int r = dir[0] + i;
                        int c = dir[1] + j;
                        if(checkBounds(r,c,n) && grid[r][c] != 0 && set.add(grid[r][c])){
                            cnt += compToCount.get(grid[r][c]); 
                        }
                    }
                    if(cnt > maxCnt){
                        maxCnt = cnt;
                    }
                    set.clear();
                }
            }
        }
        
        return maxCnt;
    }
    
    private static int dfs(int grid[][],int i,int j,int id){
        grid[i][j] = id;
        int cnt = 1;
        for(int dir[] : directions){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(checkBounds(r,c,grid.length) && grid[r][c] == 1){
                cnt += dfs(grid,r,c,id);
            }
        }
        return cnt;
    }
    
    private static int directions[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    
    private static boolean checkBounds(int i,int j,int n){
        return i>=0 && i<n && j>=0 && j<n;
    }
}