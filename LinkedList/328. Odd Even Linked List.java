/**
 * https://leetcode.com/problems/odd-even-linked-list/
 *
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp = head;
        ListNode odd = null;
        ListNode even = null;
        ListNode to = null;    
        ListNode te = null;    
        
        int i=1;
        
        while(temp!=null){
            ListNode t= temp.next;
            if(i%2==0){
                if(even==null) {
                    even=temp;
                    te=temp;
                }
                else{
                    te.next=temp;
                    te=temp;
                }
                te.next=null;
            }
            
            else{
                if(odd==null) {
                    odd=temp;
                    to=temp;
                }
                else{
                    to.next=temp;
                    to=temp;
                }
                to.next=null;
            }
            temp=t;
            i++;
        }
        
        to.next=even;
        
        return odd;
        
    }
}