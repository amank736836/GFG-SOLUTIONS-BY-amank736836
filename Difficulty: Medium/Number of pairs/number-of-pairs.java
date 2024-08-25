//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
        long ans = 0;
        long one = 0;
        long two = 0;
        long threeFour = 0;
        Arrays.sort(y);
        
        for(int ele : y){
            if(ele == 1){
                one++;
            }else if(ele == 2){
                two++;
            }else if(ele == 3 || ele == 4){
                threeFour++;
            }
        }
        
        for(int ele : x){
            if(ele != 1){
                ans += one;
                if(ele == 2){
                    ans -= threeFour;
                }
                else if(ele == 3){
                    ans += two;
                }
                int index = binarySearch(y,ele);
                ans += N - index - 1;
            }
        }
        
        return ans;
    }
    
    private int binarySearch(int y[],int ele){
        int low = 0;
        int high = y.length - 1;
        int idx = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(y[mid] <= ele){
                idx = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return idx;
    }
}