/**
 * https://leetcode.com/problems/partition-list/


Note:
    [7,2,1,3,4]
    create fake node and connect to main list
    mid,last == fakehead;

    run loop
        // on each ith become head which is lesser than x 
        if ith is less than x
            last.next = ith.next; //remove 
            ith.next = fakehead //connect to fakehead
            fakehead = ith // make it head
        else
            last=temp //update last

    // after loop
    // list is => [1, 2,-1, 3, 4] 
    // -1 is fakenode, all lesser of x in left and greater in right side
    // we want to preserve the order, 
    // reverse the list from start to fakehead.next(after reverse fakehead should be first node)
    
    result = reverse(fakehead, mid.next)

    return result.next; //skip fakenode


 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        
        // create fake node connect to main list
        ListNode newhead= new ListNode(-222);
        newhead.next=head;

        ListNode last = newhead; //previous node
        ListNode mid = newhead;  //reverse point
        ListNode temp = head;

        while(temp!=null){
            ListNode nx = temp.next;

            if(temp.val<x){
                last.next = temp.next; // remove current node
                temp.next = newhead; // connect to head node
                newhead=temp; //make it head node
            }
            else{
                last = temp; //previous node for removing
            }

            temp=nx;//update
        }
        
        
        // now all less<x in left side and all greater>x in right side of mid node
        // but lesser values are in reverse order
        // after reverse mid node become the first node

        return reverse(newhead, mid.next).next;//.next to skip first node


    }
    
    
    public ListNode reverse(ListNode head, ListNode end){
        ListNode t = head;
        ListNode pre = end;
        while(t!=null && t!=end){
            ListNode t1 = t.next;
            t.next = pre;
            pre=t;
            
            t=t1;
        }
        return pre;
    }
}