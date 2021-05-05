/**
 * https://leetcode.com/problems/sort-list/

 */
class Solution {
//Not efficient
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        //swapping values
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            ListNode t = temp.next;
            ListNode min = temp;
            int tval=temp.val;
            while(t!=null){
                if(tval>t.val) {
                    tval=t.val;
                    min = t;
                }
                t=t.next;
            }
            
            int x = min.val;
            min.val = temp.val;
            temp.val = x;
            
            temp=temp.next;
        }
        return head;
    }


//Efficient using merge sort
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        return mid(head);
    }
    
    //find middle of list and disconnect
    // mid(left head) and mid(right head)
    public ListNode mid(ListNode head){
        if(head.next==null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            if(fast==null) break;
            slow=slow.next;
        }
        ListNode sl = slow.next;
        slow.next=null;
        ListNode left = mid(head);
        ListNode right = mid(sl);
        
        return merge(left,right);
    }
    
    //merge two sorted array
    public ListNode merge(ListNode left, ListNode right){
        if(left==null) return right;
        if(right==null) return left;
        
        ListNode fhead = new ListNode(-1);
        ListNode prev = fhead;
        
        while(left!=null && right!=null){
            if(left.val<right.val){
                prev.next = left;
                prev = left;
                left=left.next;
            }
            else{
                prev.next = right;
                prev =right;
                right=right.next;
            }
        }
        
        while(left!=null){
            prev.next = left;
            prev = left;
            left=left.next;
        }
        
        
        while(right!=null){
            prev.next = right;
            prev =right;
            right=right.next;
        }
        
        return fhead.next;
    }
}