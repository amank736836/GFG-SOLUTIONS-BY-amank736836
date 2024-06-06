//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends




//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    
    int atoi(String s) {
        //Your code here
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int x = s.charAt(i);
            if(x==45 && sum == 0){
                continue;
            }else if(x>=48 && x<=57){
                sum = sum*10 + (x-48);
            }else{
                return -1;
            }
        }
        
        if(s.charAt(0) == '-'){
            return -sum;
        }
        return sum;
    }
    
}
