/*
    https://leetcode.com/problems/path-sum/

 */
class Solution {
    public boolean hasPathSum(TreeNode root, int t) {
        if(root==null) return false;
        
        if( t-root.val==0 && root.left==null && root.right==null) return true;
            
        boolean left = hasPathSum(root.left, t-root.val);
        boolean right = hasPathSum(root.right, t-root.val);
            
        return left || right;
    }

}