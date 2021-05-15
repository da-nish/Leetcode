/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/




 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null) return 0;
        return helper(root, null, null);
        
    }
    public int helper(TreeNode current, TreeNode parent, TreeNode grandparent){
        if(current == null) return 0;
        
        int val=0;
        //given condition
        if(grandparent!=null && grandparent.val%2==0){
            val+=current.val;
        }
        // pass current as parent and parent as grandparent
        val+=helper(current.left, current, parent);
        val+=helper(current.right, current, parent);
        return val;
    }
}