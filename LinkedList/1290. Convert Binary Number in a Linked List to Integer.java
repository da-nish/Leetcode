/**
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

Note:
    reverse linkedlist, then find
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        if(head==null) return 0;
        ListNode temp = reverse(head);
        int bi = 1;
        int sum=0;
            
        while(temp!=null){
            if(temp.val==1){
                sum +=bi;
            }
            bi=bi*2;
            
            temp=temp.next;
        }
        return sum;
    }
    
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode pre = null;
        
        while(temp!=null){
            ListNode t = temp.next;
            temp.next = pre;
            pre=temp;
            
            temp =t;
        }
        return pre;
    }
}