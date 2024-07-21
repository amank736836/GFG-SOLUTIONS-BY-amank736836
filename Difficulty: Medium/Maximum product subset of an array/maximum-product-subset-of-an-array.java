//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        
        if(arr.size() == 1){
            return arr.get(0);
        }
        
        long MOD = (long) 1e9 + 7;
        long pos = 0;
        long neg = 0;
        int largestNeg = Integer.MIN_VALUE;
        int negCount = 0;
        for(int num : arr){
            if(num > 0){
                if(pos == 0){
                    pos = num % MOD;
                }
                else{
                    pos = (pos * num) % MOD;
                }
            }else if(num < 0){
                if(neg == 0){
                    neg = num % MOD;
                }
                else{
                    neg = (neg * num) % MOD;
                }
                negCount++;
                largestNeg = Math.max(largestNeg,num);
            }
        }
        long res = 0;
        if(negCount < 2){
            neg = 0;
        }
        else if(neg < 0){
            neg /= largestNeg;
        }
        
        if(pos != 0){
            res = pos;
        }
        
        if(res == 0){
            res = neg;
        }
        else if(neg != 0){
            res = (res * neg) % MOD;
        }
        
        return res%MOD;
        
    }
}