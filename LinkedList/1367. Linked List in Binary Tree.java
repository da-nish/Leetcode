/**
https://leetcode.com/problems/linked-list-in-binary-tree/

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ListNode hd;
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null) return true;
        if(root==null) return false;
        
        //passing head of LL to each node of Tree
        return dfs(head, root) || ( isSubPath(head, root.left) || isSubPath(head, root.right));
    }
    
    public boolean dfs(ListNode head, TreeNode root){
        if(head==null) return true;
        if(root==null) return false;
        
        if(head.val==root.val){
             return dfs(head.next, root.left) || dfs(head.next, root.right);
        }
        return false;
    }
        
}