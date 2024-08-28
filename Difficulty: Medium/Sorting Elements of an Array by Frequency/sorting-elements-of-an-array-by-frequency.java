//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        
        List<Map.Entry<Integer,Integer>> mapList = new LinkedList<>(map.entrySet());
        
        mapList.sort((a,b)->{
            int freqCompare = b.getValue() - a.getValue();
            int valueCompare = a.getKey() - b.getKey();
            if(freqCompare == 0){
                return valueCompare;
            }else{
                return freqCompare;
            }
        });
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> entry : mapList){
            for(int i=0;i<entry.getValue();i++){
                list.add(entry.getKey());
            }
        }
        
        return list;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends