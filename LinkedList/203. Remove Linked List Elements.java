/**
https://leetcode.com/problems/remove-linked-list-elements/

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        
        ListNode newhead = null;
        ListNode temp = head;

        ListNode fhead = new ListNode(-1);//fake node, to handle first node==val
        ListNode pre = fhead;
        
        while(temp!=null){

            if(temp.val==val){
                //if last node set null
                if(temp.next==null) pre.next=null;
            }
            else{
                pre.next=temp;
                pre=temp;
            }

            //update
            temp=temp.next;
            
        }//end loop    
        return fhead.next;
    }
}