/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/submissions/

Note: tricky question

	copy value of next node and delete next node
*/
class Solution {
    public void deleteNode(ListNode node) {        
        node.val= node.next.val;
        node.next = node.next.next;
    }
}