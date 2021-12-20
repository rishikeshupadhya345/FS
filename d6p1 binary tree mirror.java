/*Mr Rakesh is interested to work on Data Structures.
He has constructed a BinaryTree-BT.

He asked his friend Anil to check whether BT is self mirror tree or not.
Can you help Anil to find and return "true" if the given BT is a self mirror tree,
otherwise return "false".

Implement the class Solution:
   1. public boolean isSelfMirrorTree(BinaryTreeNode root): returns a boolean value.
  
NOTE:
	- In the tree '-1', indicates empty(null).
   
Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false
*/
/*
//TreeNode Structure for Your Reference..

class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

*/
import java.util.*;
class Solution {
    public boolean isSelfMirrorTree(BinaryTreeNode root) {
        // Implement Your Code here..
        ArrayDeque<BinaryTreeNode> q= new ArrayDeque<>();
        q.offerLast(root);
        while(!q.isEmpty()){
            int n=q.size();
            int s[]=new int[n];
            int ns=0;
            for(int i=0;i<n;i++){
                BinaryTreeNode cur=q.pollFirst();
                s[ns]=cur.data;
                ns++;
                if(cur.left!=null) q.offerLast(cur.left);
                if(cur.right!=null) q.offerLast(cur.right);
                
            }
            ns--;
            int j=0;
            while(j<=ns){

                if(s[j]!=s[ns]){
                    return false;
                }
                j++;
                ns--;
            }
        }
        return true;
    }
}
