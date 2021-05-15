/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        
        List<Integer> li = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        boolean fl = false;
        
        while(qu.size()>0){
            
            TreeNode temp = qu.remove();
            
            if(temp==null){
                fl=!fl;
                list.add(new ArrayList<>(li));
                if(qu.size()>0) qu.add(null);
                li.clear();                
                continue;

            }
            else{
                if(fl) li.add(0,temp.val);
                else  li.add(temp.val);
            }
            
            if(temp.left!=null) qu.add(temp.left);
            if(temp.right!=null) qu.add(temp.right);
        }
        
        return list;
        
    }
}