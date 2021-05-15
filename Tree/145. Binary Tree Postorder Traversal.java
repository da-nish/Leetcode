/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        post(root,list);
        return list;
        
    }
    
    public void post(TreeNode root, List<Integer> list){
        if(root==null) return ;
        
        post(root.left, list);
        post(root.right, list);
        list.add(root.val);
    }
}