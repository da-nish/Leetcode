/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode a = headA;
        ListNode b = headB;
    
        //if a & b have different len, then we will stop the loop after second iteration

        while( a != b){
            //when it is list end, start from B
            if(a==null) a=headB;
            else a=a.next;
            
            //when it is list end, start from A
            if(b==null) b=headA;
            else b=b.next;
            
        }
    
        return a;
    }
}