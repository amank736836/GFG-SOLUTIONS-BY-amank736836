//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        Stack<String> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            int j=i;
            while(j < str.length() && str.charAt(j) != '.'){
                j++;
            }
            stack.push(str.substring(i,j));
            i = j;
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans += stack.pop();
            if(stack.size() > 0){
                ans += ".";
            }
        }
        return ans;
    }
}