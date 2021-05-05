/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * https://www.youtube.com/watch?v=Qq-vnKmzJR0

Note:

check cycle is exist Or Not

if cycle exist 
    then break the loop from the node(suppose Z node);
    
Now run two pointer (from head and from Z node)
    z=z.next;
    h=h.next;
    if z==h: return=current node;



we want to find ith node where cycle was begin.
head to ith node distance === distance of cycle node(where slow and fast were meet) to end node +1

head to ith node == x distance
cycle node end == x distance +1 (x is assumtion)(+1 to end to cycle jump)



 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)return null;
        boolean cycle = false;
        ListNode slow = head;
        ListNode fast = head;

        //checking cycle exist or not
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle = true;
                break;
            }
        }
        //when cycle is not exist
        if(cycle==false) return null; 

        // when cycle exist
        // at which point cycle was found 
        // run two slow pointer (first from head and second where cycle was found) 
        // where both pointers will meet is the result node 
        ListNode temp=head;
        while(temp!=slow){
            temp=temp.next;
            slow=slow.next;
        }
        
        return temp;
    }
}