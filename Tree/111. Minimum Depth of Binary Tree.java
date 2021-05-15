/**
https://leetcode.com/problems/minimum-depth-of-binary-tree/

*/


class Solution {
    public int minDepth(TreeNode root) {
        // root is null
        if(root==null) return 0;
        
        int val = 0;

        
        if(root.left!=null && root.right!=null){
            val = Math.min(
                minDepth(root.left)+1 ,
                minDepth(root.right)+1
            );
        }
        //when leaf node
        else if(root.left==null && root.right==null) val = 1;
        //when left is null call right
        else if(root.left==null) val = minDepth(root.right)+1;
        //when right is null call left
        else if(root.right==null) val = minDepth(root.left)+1;
        
            
        return val;
    }
}