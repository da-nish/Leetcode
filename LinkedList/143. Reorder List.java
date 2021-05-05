/**
https://leetcode.com/problems/reorder-list/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }


Note:
    find middle and split (left-side should be larger in odd length)
    reverse second half
    connect one by one




 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return;
        
        ListNode temp = head;
        ListNode mid = mid(head);
        mid = reverse(mid);
        
        
        while(temp!=null && mid!=null){
            
            ListNode tm1 = temp.next;   //store first half next
            ListNode tm2 = mid.next;    //store second half next
            
            temp.next = mid;    //connect to second
            mid.next=tm1;       //connect to first.next
            
            mid=tm2;    //update
            temp=tm1;   //update 
        }
        return ;
    }
    
    public ListNode mid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            if(fast==null) return slow;
            slow = slow.next;
        }
        ListNode re = slow.next;
        slow.next=null;
        return re;
    }
    
    
    public ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode pre=null;
        
        while(temp!=null){
            ListNode t = temp.next;
            temp.next=pre;
            pre=temp;
            
            temp=t;
        }
        return pre;
    }
}