//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends



class Pair{
    int first;
    int second;
    int index;
    Pair(int u,int v,int i){
        first = u;
        second = v;
        index = i;
    }
}

class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        Pair arr[] = new Pair[N];
        for(int i=0;i<N;i++){
            arr[i] = new Pair(S[i],F[i],i+1);
        }
        Arrays.sort(arr , (a,b) -> a.second - b.second);
        
        /*for(int i=0;i<N;i++){
            System.out.println(arr[i].first + " " + arr[i].second);
        }*/
        
        int MF = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            if(arr[i].first > MF){
                MF = arr[i].second;
                ans.add(arr[i].index);
            }
        }
        
        Collections.sort(ans);
        
        return ans;
        
        
    }
}
        
