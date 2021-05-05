/**
    https://leetcode.com/problems/palindrome-linked-list/

Note: find middle
    reverse second half
    split
    compare





edge case:
    [1,2]
    when finding middle with slow and fast pointer, fast will reach end(null) and slow reach last node(2)
    to reverse, sending slow.next, (now slow.next==null)

    to handle, update slow only when (temp!=null)


 */



class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        ListNode temp = head;
        ListNode slow = head;
        
        //find middle node;
        while(temp!=null && temp.next!=null){
            temp=temp.next.next;
            if(temp!=null)
                slow=slow.next;
        }

        //reverse right half
        ListNode rev = rev(slow.next);
        //split
        slow.next=null;
        
        //compare
        temp=head;
        while(temp!=null && rev!=null){
            if(temp.val==rev.val){
                temp=temp.next;
                rev=rev.next;
            }
            else return false;
        }
        
        return true;
        
    }
    
    //Reverse LL
    public ListNode rev(ListNode head){
        ListNode pre = null;
        ListNode temp = head;
        
        while(temp!=null){
            ListNode t = temp.next;
            temp.next = pre;
            pre = temp;
            
            temp = t;
        }
        
        return pre;
    }
}