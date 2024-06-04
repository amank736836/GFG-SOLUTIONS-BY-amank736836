//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        int v;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                v = hm.get(c);
                hm.put(c,++v);
            }else{
                hm.put(c,1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        char max_char = 'a';
        
        while(k-->0){
            for(char c : hm.keySet()){
                v = hm.get(c);
                if(v>=max){
                    max = v;
                    max_char = c;
                }
            }
            hm.put(max_char,--max);
        }
        
        int sum = 0;
        for(char c : hm.keySet()){
            v = hm.get(c);
            sum += v*v;
        }
        
        
        return sum;
    }
}