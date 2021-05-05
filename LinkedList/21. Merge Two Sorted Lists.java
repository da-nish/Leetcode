/*
https://leetcode.com/problems/merge-two-sorted-lists/

Note: 2 pointer technique
    use fakehead or newhead
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = null;
        ListNode t=null; // last/previous node

        while(temp1!=null && temp2!=null){

            if(temp1.val<temp2.val){
                if(head==null){
                    head=temp1;
                }
                else{
                    t.next=temp1;
                }
                t=temp1;
                temp1=temp1.next;
                //update only smaller node
            }
            else{
                if(head==null){
                    head=temp2;
                }
                else{
                    t.next=temp2;
                }
                t=temp2;
                temp2=temp2.next;
                //update only smaller node
            }
        }
        
        //add remaining nodes
        while(temp1!=null){
            t.next=temp1;
            t=temp1;
            temp1 = temp1.next;
        }

        //add remaining nodes
        while(temp2!=null){
            t.next=temp2;
            t=temp2;
            temp2 = temp2.next;
        }
        
        return head;
    }
}