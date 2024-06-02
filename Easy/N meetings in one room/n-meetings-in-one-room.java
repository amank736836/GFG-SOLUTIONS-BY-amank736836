//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Pair{
    int first;
    int second;
    Pair(int u,int v){
        first = u;
        second = v;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Pair arr[] = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(start[i],end[i]);
        }
        Arrays.sort(arr , (a,b) -> a.second - b.second);
        
        int m = 0;
        int interviewEnd = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i].first > interviewEnd){
                m++;
                interviewEnd = arr[i].second;
            }
        }
        
        return m;
    }
}
