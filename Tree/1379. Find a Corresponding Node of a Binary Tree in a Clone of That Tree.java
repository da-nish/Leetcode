/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode m, final TreeNode c, final TreeNode t) {
        if(m==null) return null;
        
        if(m==t) return c;
        
        TreeNode left = getTargetCopy(m.left, c.left, t);

        //when left return some node, it is a result
        if(left!=null) return left;
        //search in right side when didn't find in left side
        
        //search in right side
        TreeNode right = getTargetCopy(m.right, c.right, t);

        return right;
    }
}