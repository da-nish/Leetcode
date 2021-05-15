/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
class Solution {
    public int goodNodes(TreeNode root) {
        re=0;
        helper(root, -999999);
        return re;
    }
    
    static int re;
    public void helper(TreeNode root, int mxt){
        if(root==null) return ;
        
        if(mxt<=root.val) {
            re++;
            mxt=root.val;
        }
        
        helper(root.left, mxt);
        helper(root.right, mxt);
    }
}