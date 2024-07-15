//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        int result = helper(s,d,0);
        if(result >= (int) 1e8){
            return "-1";
        }
        
        return String.valueOf(result);
    }
    
    public int helper(int s,int d,int dig){
        if(d == 0 && s == 0){
            return dig;
        }
        if(d == 0 || s < 0){
            return (int) 1e8;
        }
        
        int take = (int) 1e8;
        for(int i=0;i<=9;i++){
            if(dig == 0 && i == 0 && d != 1){
                continue;
            }
            take = Math.min(take , helper(s-i,d-1,dig * 10 + i));
        }
        
        return take;
    }
}
