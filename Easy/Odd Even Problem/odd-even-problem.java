//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        int x = 0;
        int y = 0;
        int[] count = new int[27];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'a' + 1]++;
        }
        
        for(int i=1;i<=26;i++){
            if(count[i] != 0 && count[i]%2 == 0 && i%2 ==0){
                x++;
            }
            else if(count[i]%2 == 1 && i%2 == 1){
                y++;
            }
        }
        int sum = x+y;
        if(sum%2 == 1){
            return "ODD";
        }
        else{
            return "EVEN";
        }
    }
}
