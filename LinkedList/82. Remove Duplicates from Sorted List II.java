/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

use fakehead and do not connect with head
last = fakehead

when find unique node
    last.next = curr //connect 
    last= curr //new last
    last.next //disconnect,(when we find unique node then connect otherwise iterate the list) 
*/


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode fhead = new ListNode(0);
        // fhead.next=head; //IMP do not connect fakehead
        ListNode last = fhead;
        ListNode temp=head;
        
        while(curr!=null){
            
            //next node
            ListNode t=curr.next;

            //consider Node
            ListNode t=curr.next;
            if(t==null || t.val!=curr.val){
                last.next = curr;
                last=curr;
                last.next=null; //imp, disconnect all node, (next time we find unique node then connect)
                if(t==null) break;
            }

            //Not consider
            //run loop until found Non-duplicate
            while(t!=null && t.val==curr.val){
                t=t.next;
            }//after the loop, t will skip all the current duplicates.
            

            //update
            curr = t;

            //imp, update 
            //this update condition make this code O(n) time
        }
        return newhead;
    }
}