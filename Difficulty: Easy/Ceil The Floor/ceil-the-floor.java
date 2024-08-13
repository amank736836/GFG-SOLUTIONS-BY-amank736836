//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == x){
                return new int[]{arr[i],arr[i]};
            }
            else if(arr[i]<x){
                floor = Math.max(floor,arr[i]);
            }else{
                ceil = Math.min(ceil,arr[i]);
            }
        }
        if(floor == Integer.MIN_VALUE){
            floor = -1;
        }
        if(ceil == Integer.MAX_VALUE){
            ceil = -1;
        }
        return new int[]{floor,ceil};
    }
}
