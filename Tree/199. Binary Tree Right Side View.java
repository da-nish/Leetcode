/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        map = new TreeMap<>();
        rightview(root, 0);
        List<Integer> list = new ArrayList<>();
        
        for(int i: map.values()) list.add(i);
        
        return list;
    }


    Map<Integer, Integer> map; 
    public void rightview(TreeNode root, int l){
        if(root==null) return;
        
        map.put(l, root.val);
        rightview(root.left, l+1);
        rightview(root.right, l+1);//increase level
        
    }
}