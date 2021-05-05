/**
https://leetcode.com/problems/rotate-list/submissions/


Note : find lenth, catch the k+1 node from LAST


Edge cases:
    LL is null, then no change
    LL len is 1, then no change
    LL len == k, then no change
    LL len < K, then k=k%len


*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        //edge case
        
        ListNode temp = head;
        ListNode newhead = head;
        
        //finding length
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }

        //edge case
        if(len==k) return head;
        if(len<k) k=k%len;


        int i=0;
        temp = head;
        while(temp!=null){
            //find previous of kth node
            if(len-k-1==i) newhead=temp;
            //if last node, break loop without update because we will need it to connect with first node
            if(temp.next==null) break;

            temp=temp.next;
            i++;
            
        }

        temp.next = head;   //connect last to first
        head = newhead.next;//update head
        newhead.next=null;  //set null kth previous node, otherwise circuler LL
        
        return head;
    }
    
}