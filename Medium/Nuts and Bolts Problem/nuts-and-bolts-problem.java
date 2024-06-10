//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        
        for(int i=0;i<n;i++){
            if(nuts[i] == '!'){
                nuts[i] = '0';
            }
            else if(nuts[i] == '#'){
                nuts[i] = '1';
            }
            else if(nuts[i] == '$'){
                nuts[i] = '2';
            }
            else if(nuts[i] == '%'){
                nuts[i] = '3';
            }
            else if(nuts[i] == '&'){
                nuts[i] = '4';
            }
            else if(nuts[i] == '*'){
                nuts[i] = '5';
            }
            else if(nuts[i] == '?'){
                nuts[i] = '6';
            }
            else if(nuts[i] == '@'){
                nuts[i] = '7';
            }
            else if(nuts[i] == '^'){
                nuts[i] = '8';
            }
            
            if(bolts[i] == '!'){
                bolts[i] = '0';
            }
            else if(bolts[i] == '#'){
                bolts[i] = '1';
            }
            else if(bolts[i] == '$'){
                bolts[i] = '2';
            }
            else if(bolts[i] == '%'){
                bolts[i] = '3';
            }
            else if(bolts[i] == '&'){
                bolts[i] = '4';
            }
            else if(bolts[i] == '*'){
                bolts[i] = '5';
            }
            else if(bolts[i] == '?'){
                bolts[i] = '6';
            }
            else if(bolts[i] == '@'){
                bolts[i] = '7';
            }
            else if(bolts[i] == '^'){
                bolts[i] = '8';
            } 
        }
        
        Arrays.sort(nuts);
        Arrays.sort(bolts);
        
        for(int i=0;i<n;i++){
            if(nuts[i] == '0'){
                nuts[i] = '!';
            }
            else if(nuts[i] == '1'){
                nuts[i] = '#';
            }
            else if(nuts[i] == '2'){
                nuts[i] = '$';
            }
            else if(nuts[i] == '3'){
                nuts[i] = '%';
            }
            else if(nuts[i] == '4'){
                nuts[i] = '&';
            }
            else if(nuts[i] == '5'){
                nuts[i] = '*';
            }
            else if(nuts[i] == '6'){
                nuts[i] = '?';
            }
            else if(nuts[i] == '7'){
                nuts[i] = '@';
            }
            else if(nuts[i] == '8'){
                nuts[i] = '^';
            }
            
            if(bolts[i] == '0'){
                bolts[i] = '!';
            }
            else if(bolts[i] == '1'){
                bolts[i] = '#';
            }
            else if(bolts[i] == '2'){
                bolts[i] = '$';
            }
            else if(bolts[i] == '3'){
                bolts[i] = '%';
            }
            else if(bolts[i] == '4'){
                bolts[i] = '&';
            }
            else if(bolts[i] == '5'){
                bolts[i] = '*';
            }
            else if(bolts[i] == '6'){
                bolts[i] = '?';
            }
            else if(bolts[i] == '7'){
                bolts[i] = '@';
            }
            else if(bolts[i] == '8'){
                bolts[i] = '^';
            }
            
        }
    }
}