/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

Note:
same as level order traverse, but in reverse order so add in 0-index instead of last-index

 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        
        if(root==null) return list;
        
        qu.add(root);
        qu.add(null);
        
        List<Integer> li = new ArrayList<>();
        while(qu.size()>0){
            
            TreeNode temp = qu.remove();
            
            if(temp==null){
                //appending in 0-index
                list.add(0,new ArrayList<>(li));
                if(qu.size()>0) qu.add(null);
                li.clear();
                continue;
            }
            else{
                li.add(temp.val);
            }
            
            if(temp.left!=null){
                qu.add(temp.left);                
            }
            if(temp.right!=null){
                qu.add(temp.right);
            }
            
            
        }//loop end
        
        return list;
        
    }
    
    
}