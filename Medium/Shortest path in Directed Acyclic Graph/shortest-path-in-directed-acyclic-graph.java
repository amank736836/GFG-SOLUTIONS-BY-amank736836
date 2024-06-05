//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int value;
    int weight;
    Pair(int v,int w){
        value = v;
        weight = w;
    }
}
//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<N;i++){
		    adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++){
		    adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}
		
		int indegree[] = new int[N];
		for(int i=0;i<N;i++){
		    for(Pair val : adj.get(i)){
		        indegree[val.value]++;
		    }
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0;i<N;i++){
		    if(indegree[i] == 0){
		        q.add(i);
		    }
		}
		
		int []topologicalSort = new int[N];
		int index = 0;
		while(!q.isEmpty()){
		    int x = q.remove();
		    topologicalSort[index++] = x; 
		    
		    for(Pair val : adj.get(x)){
		        indegree[val.value]--;
		        if(indegree[val.value] == 0){
		            q.add(val.value);
		        }
		    }
		}
		
		int[] dist = new int[N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0] = 0;
		
		for(int i=0;i<N;i++){
		    int node = topologicalSort[i];
		    if(dist[node] != Integer.MAX_VALUE){
		        for(Pair val : adj.get(node)){
		            if(dist[node] + val.weight < dist[val.value]){
		                dist[val.value] = dist[node] + val.weight;
		            }
		        }
		    }
		}
		
		for(int i=0;i<N;i++){
		    if(dist[i] == Integer.MAX_VALUE){
		        dist[i] = -1;
		    }
		}
		
		
		return dist;
		
	}
}