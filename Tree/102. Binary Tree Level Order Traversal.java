/**
https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
            
            List<List<Integer>> list = new ArrayList<>();
            
            doo(root, 0, list);
            return list;
    }
        
        
        public void doo(TreeNode root, int i, List<List<Integer>> list){
                if(root==null) return;
                
                if(list.size()-1>=i){
                        List<Integer> li = list.get(i);
                        li.add(root.val);
                        list.set(i,li);
                }else{
                        List<Integer> li = new ArrayList<>();
                        li.add(root.val);
                        list.add(i, li);
                }
                
                doo(root.left,i+1,list);
                doo(root.right,i+1,list);
                
        }
}