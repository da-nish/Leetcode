/**
 *https://leetcode.com/problems/maximum-binary-tree-ii/
 */
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        
        return insert(root, val);
        
    }
    
    public TreeNode insert(TreeNode root, int val){

        //left node
        if(root==null) return new TreeNode(val);;
        
        
        if(root.val<val){
            TreeNode n = new TreeNode(val);
            n.left=root;
            
            return n;
        }
        
        //since val appended from most right possition,
        //new val node can be inserted only from right side
        root.right = insert(root.right, val);
        return root;
    }
}