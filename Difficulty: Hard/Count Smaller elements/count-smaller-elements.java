//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int[] constructLowerArray(int[] arr) {
        // code here
      
        int n = arr.length;
        int counts[] = new int[n];
        int indices[] = new int[n];
        for(int i=0;i<n;i++){
            indices[i] = i;
        }
        mergeSort(arr,indices,counts,0,n-1);
        return counts;
        
    }
    
    private void mergeSort(int arr[],int indices[],int counts[],int start,int end){
      
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr,indices,counts,start,mid);
        mergeSort(arr,indices,counts,mid+1,end);
        merge(arr,indices,counts,start,mid,end);
        
    }
    
    private void merge(int arr[],int indices[],int counts[],int start,int mid,int end){
      
        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        
        int leftIndices[] = new int[leftSize];
        int rightIndices[] = new int[rightSize];
        
        for(int i=0;i<leftSize;i++){
            leftIndices[i] = indices[start + i];
        }
        
        for(int i=0;i<rightSize;i++){
            rightIndices[i] = indices[mid+1+i];
        }
        
        int l = 0;
        int r = 0;
        int k = start;
        int rightCount = 0;
        
        while(l<leftSize && r<rightSize){
            if(arr[leftIndices[l]] <= arr[rightIndices[r]]){
                counts[leftIndices[l]] += rightCount;
                indices[k++] = leftIndices[l++];
            }
            else{
                rightCount++;
                indices[k++] = rightIndices[r++];
            }
        }
        
        while(l<leftSize){
            counts[leftIndices[l]] += rightCount;
            indices[k++] = leftIndices[l++];
        }
        
        while(r<rightSize){
            indices[k++] = rightIndices[r++];
        }
        
    }
    
}