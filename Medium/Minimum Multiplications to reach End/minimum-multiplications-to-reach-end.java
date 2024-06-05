//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int num;
    int steps;
    Pair(int n,int s){
        num = n;
        steps = s;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        if(start == end){
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start , 0));
        
        int []steps = new int[100000];
        Arrays.fill(steps , Integer.MAX_VALUE);
        steps[start] = 0;
        while(!q.isEmpty()){
            Pair current = q.poll();
            int currentNum = current.num;
            int currentSteps = current.steps;
            
            for(int multiplier : arr){
                int nextNum = (currentNum* multiplier) % 100000;
                
                if(nextNum == end){
                    return currentSteps + 1;
                }
                
                if(currentSteps + 1 < steps[nextNum]){
                    steps[nextNum] = currentSteps + 1;
                    q.add(new Pair(nextNum , currentSteps + 1));
                }
            }
        }
        return -1;
    }
}
