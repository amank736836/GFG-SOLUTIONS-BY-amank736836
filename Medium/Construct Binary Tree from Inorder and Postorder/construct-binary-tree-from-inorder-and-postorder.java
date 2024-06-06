//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        Node root = buildTreeUtil(in,post,0,n-1,0,n-1);
        return root;
    }
    
    public Node buildTreeUtil(int in[],int post[],int inS,int inE,int postS,int postE){
        
        if(inS>inE){
            return null;
        }
        Node root = new Node(post[postE]);
        if (inS == inE){
            return root;
        }
        int x = search(in,inS,inE,root.data);
        root.left =  buildTreeUtil(in,post,inS,x-1,postS,postS-inS+x-1);
        root.right =  buildTreeUtil(in,post,x+1,inE,postS-inS+x,postE-1);
        
        return root;
        
    }
    
    public int search(int in[],int inS,int inE,int x){
        for(int i=inS;i<=inE;i++){
            if(in[i] == x){
                return i;
            }
        }
        return -1;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
