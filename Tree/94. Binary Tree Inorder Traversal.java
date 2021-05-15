/**
 *https://leetcode.com/problems/binary-tree-inorder-traversal/

Inorder : Left -> Head -> Right

 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
                
        list.clear();
        if(root==null) return list;
            inOrder(root);
            return list;
            
    }
        static List<Integer> list = new ArrayList<>();
        public void inOrder(TreeNode root){
                if(root==null) return;
                
                inOrder(root.left);
                list.add(root.val);
                inOrder(root.right);
                
        }
        
}