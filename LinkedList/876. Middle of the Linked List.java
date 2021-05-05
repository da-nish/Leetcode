/**
 * Definition for singly-linked list.
 * public class ListNode {
 https://leetcode.com/problems/middle-of-the-linked-list/
 
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            if(fast==null){
                // when even length
                // slow left middle 
                // slow.next right middle 
                return slow.next;
            }

            slow=slow.next;
        }

        
        return slow;
    }
}