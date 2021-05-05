/**
 *https://leetcode.com/problems/insertion-sort-list/

 
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode fhead = new ListNode(-10000);
        fhead.next=head;
        ListNode temp = head;
        
        while(temp.next!=null){
            
            if(temp.val>temp.next.val){
                ListNode curr = temp.next;
                ListNode prev = fhead;
                while(prev.next.val<curr.val){
                    prev=prev.next;
                }
                
                temp.next=curr.next;
                curr.next=prev.next;
                prev.next=curr;
                
            }
            else{
                temp=temp.next;
            }
           
            
        }
        return fhead.next;
    }
    
}