//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    
    public int findUltimateParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node , ultimateParent);
        return ultimateParent;
    }
    
    public void unionByRank(int u,int v){
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if(ultimateParentU == ultimateParentV){
            return;
        }
        if(rank.get(ultimateParentU) < rank.get(ultimateParentV)){
            parent.set(ultimateParentV , ultimateParentU);
        }
        else if(rank.get(ultimateParentV) < rank.get(ultimateParentU)){
            parent.set(ultimateParentU , ultimateParentV);
        }
        else{
            parent.set(ultimateParentV , ultimateParentU);
            int rankU = rank.get(ultimateParentU);
            rank.set(ultimateParentU , rankU + 1);
        }
    }
    
    public void unionBySize(int u,int v){
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if(ultimateParentU == ultimateParentV){
            return;
        }
        if(size.get(ultimateParentU) < size.get(ultimateParentV)){
            parent.set(ultimateParentU , ultimateParentV);
            size.set(ultimateParentV , ultimateParentU + ultimateParentV);
        }
        else{
            parent.set(ultimateParentV , ultimateParentU);
            size.set(ultimateParentU , ultimateParentU + ultimateParentV);
        }
    }
    
}

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
    DisjointSet djs = new DisjointSet(accounts.size());
    
    HashMap<String,Integer> map = new HashMap<>();
    for(int i=0;i<accounts.size();i++){
        for(int j=1;j<accounts.get(i).size();j++){
            String str = accounts.get(i).get(j);
            if(map.containsKey(str)){
                djs.unionBySize(i,map.get(str));    
            }
            else{
                map.put(str,i);
            }
        }
    }
    
    List<List<String>> mailDetails = new ArrayList<>();
    for(int i=0;i<accounts.size();i++){
        mailDetails.add(new ArrayList<>());
    }
    for(Map.Entry<String,Integer> element : map.entrySet()){
        String str = element.getKey();
        int node = djs.findUltimateParent(element.getValue());
        mailDetails.get(node).add(str);
    }
    
    List<List<String>> ans = new ArrayList<>();
    for(int i=0;i<accounts.size();i++){
        if(mailDetails.get(i).size() != 0){
            Collections.sort(mailDetails.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String str : mailDetails.get(i)){
                temp.add(str);
            }
            ans.add(temp);
        }
    }
    return ans;
    
  }
}
     