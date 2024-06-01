//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
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



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i) == '.'){
                ans.append(temp.reverse() + ".");
                temp = new StringBuilder();
            }else{
                temp.append(S.charAt(i));
            }
        }
        ans.append(temp.reverse());
        return ans.toString();
    }
}