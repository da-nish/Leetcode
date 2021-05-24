/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
		return sort(nums,0,nums.length-1);    
    }
    
    public TreeNode sort(int ar[], int l, int r){
        if(l>r) return null;
        
        int n = ar.length;
        int m = (l+r)/2;
        
        TreeNode head = new TreeNode(ar[m]);
        
        head.left = sort(ar, l, m-1);
        head.right = sort(ar, m+1, r);
        
        return head;
    }
}