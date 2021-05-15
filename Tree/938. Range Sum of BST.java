/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        
        int val = 0;
        
        if(root.val>=low && root.val<=high) val+=root.val;
        
        int l = rangeSumBST(root.left, low, high);
        int r = rangeSumBST(root.right, low, high);
        
        return val+l+r;
    }
}