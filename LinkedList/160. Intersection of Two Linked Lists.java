/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/

l1 and l2 can be different size
and will meet at same point

both the pointers are running with same speed 
(when l1 and l2 complete same distance they will meet at the same point )



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