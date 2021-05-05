/**
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

Note: (change the values)

    find left and right node and swap the values

 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        
        int i=1;
        ListNode temp = head;
        ListNode left = head;
        ListNode right = head;
        ListNode last = head;
        
        while(temp!=null){
            //i==k set left =current
            if(i==k) left = temp;

            //i>=k, window technique
            if(i>=k && temp.next!=null) right=right.next;
            
            i++;
            temp=temp.next;
        }
        // System.out.println(left.val+"-"+right.val);
       
        
        
        int val = left.val;
        left.val=right.val;
        right.val=val;
        
        return head;
    }
}