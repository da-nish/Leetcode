/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null) return null;
        return build(nums, 0, nums.length-1);
    }
    
    public TreeNode build(int ar[], int start, int end){
        if(start>end) return null;
        
        //find max value index 
        int mx_index = start;
        for(int i=start+1; i<=end; i++){
            if(ar[i]>ar[mx_index]) mx_index=i;
        }
        
        TreeNode node = new TreeNode(ar[mx_index]);
        
        node.left = build(ar, start, mx_index-1);
        node.right = build(ar, mx_index+1, end);
        
        return node;
        
    }
    
}