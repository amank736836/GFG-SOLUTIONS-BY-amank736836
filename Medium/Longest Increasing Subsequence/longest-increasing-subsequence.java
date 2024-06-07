//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends



class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        int dp[] = new int[size];
        dp[0] = a[0];
        int len = 1;
        for(int i=1;i<size;i++){
            if(a[i] < dp[0]){
                dp[0] = a[i];
            }
            else if(a[i] > dp[len-1]){
                dp[len] = a[i]; 
                len++;
            }
            else{
                int index = binarySearch(dp,0,len-1,a[i]);
                dp[index] = a[i];
            }
        }
        return len; 
        
    }
    
    static int binarySearch(int a[],int low,int high,int x){
        while(low<high){
            int mid = low + (high - low) / 2;
            if( x > a[mid]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
} 