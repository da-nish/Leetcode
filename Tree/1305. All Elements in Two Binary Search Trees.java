/*
 https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        helper(root1,list);
        helper(root2,list);
        
        if(root1==null || root2==null) return list;
        int g = list.size()/2;


        //using GAF method for sorting 
        while(g>0){
            int left = 0;
            int right = left+g;
            
            while(right<list.size()){
                
                if(list.get(left)>list.get(right)){
                    int t = list.get(left);
                    list.set(left, list.get(right));
                    list.set(right, t);    
                }
                left++;
                right++;
                
            }
            g--;
        }
        return list;
    }
    

    //traversing left -> head -> right
    public void helper(TreeNode root1, List<Integer> list){
        
        if(root1==null) return;
        
        helper(root1.left, list);
        list.add(root1.val);
        helper(root1.right, list);
        
    }
}