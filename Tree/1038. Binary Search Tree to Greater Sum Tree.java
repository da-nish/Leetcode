/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if(root==null) return root;
        i=0;
        helper(root);
        return root;
    }
    static int i=0;
    public static void helper(TreeNode root){
        if(root==null) return;
        
        helper(root.right);
        
        root.val  += i;
        i=root.val;
        
        helper(root.left);
        
    }
}


// ------------with temp node store--------------------------------
class Solution {
   public TreeNode bstToGst(TreeNode root) {
        reversedInorder(root, new TreeNode(0));
        return root;
    }
    private void reversedInorder(TreeNode node, TreeNode sum) {
        if (node == null) { return; }
        reversedInorder(node.right, sum);
        sum.val += node.val;
        node.val = sum.val;
        reversedInorder(node.left, sum);
    }
}