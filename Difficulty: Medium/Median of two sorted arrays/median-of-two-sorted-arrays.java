//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int sumOfMiddleElements(int arr1[], int arr2[]) {
        // code here
        int n = arr1.length;
        int l = 0;
        int r = n;
        int ans = -1;
        while(l <= r){
            int mid = (l + r) / 2;
            int s1 = arr1[mid - 1];
            int e1 = arr1[mid];
            int mid2 = n - mid;
            int s2 = arr2[mid2 - 1];
            int e2 = arr2[mid2];
            if(s1 <= e2 && s2 <= e1){
                return Math.max(s1,s2) + Math.min(e1,e2);
            }
            if(s1 > e2){
                r = mid - 1;
            }
            if(s2 > e1){
                l = mid + 1;
            }
        }
        
        return 0; // This case will never occur for valid input
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.sumOfMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends