/*
https://leetcode.com/problems/swap-nodes-in-pairs/
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        
        ListNode newhead = head.next;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = null;
        
        while(second!=null){
            third = second.next;
            
            second.next = first;
            
            if(third==null||third.next==null){//when fouth node doesnt exist
                first.next = third;
                break;
            }
            
            first.next = third.next; // point fourth node
                
            first = third;
            second = third.next;
        }
        
        return newhead;        
    }
}