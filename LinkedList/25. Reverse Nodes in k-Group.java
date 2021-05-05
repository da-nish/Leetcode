/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/

Note:
    suppose 'k' is group size
    use fakehead or newhead

    1. find 1st-node and k+1 node

    2. reverse(1st, k+1){ 
        return k-th node
        //use this condition k+1!=current (in while loop)
        //make 1st-node points to k+1 node
    }
    3. use first and last extra pointers to run loop
        first points to first node of current group
        last points to last node of previous group




 */
class Solution {

    //WITH NEW-HEAD 
    public ListNode reverseKGroup(ListNode head, int k) {
        // edge case
        if(head==null || head.next==null || k<=1) return head;
        
        ListNode newhead = null;
        ListNode first = head; //first node
        ListNode last = head; //first node, become last after reverse
        // last node of previous reversed group
        
        while(first!=null){
            
            ListNode temp = first;
            
            // skip 
            int x=k;
            while(temp!=null && x!=0){
                x--;
                temp=temp.next;
            }

            //when nodes< group lenth
            if(x!=0){
                //connecting prevous group with current node
                //last.next = first; 
                //in reverse() we set last.next =null, so connect with current
                //No need to connect, doing this in reverse()
                break;
            }

            //newhead
            if(newhead==null){
                //reverse() return first node after reverse and set last.next=null;
                newhead = reverse(first, temp);
            }
            else{
                //reverse() return first node after reverse and set last.next=null;
                last.next = reverse(first, temp);
            }
            
            last = first;//first node is became a last node(after reverse) last use to connect with new group
            first = temp;//temp is first node of next group, direct jump to next group
        }

        return newhead;
    }
    

    //WITH FAKE NODE    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null || head.next==null || k<=1) return head;
        
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        ListNode last = newhead;
        ListNode first = head;
        
        
        while(first!=null){
            ListNode temp = first;
            int x=k;
            
            // find group
            while(temp!=null && x!=0){
                x--;
                temp=temp.next;
            }
            // now temp points to k+1 node 
            // (ex: point 3rd-node when group size=2, ex: point 4rd-node when group size=3)
            
            if(x!=0){
                //when sufficient nodes are not there to form group 
                //don't reverse, break the loop 
                break;
            }

            //connecting previous group(last-node) with 1st node of reversed current group
            //in reverse(first,temp) first=1st node and temp=last+1 node
            //first pointing to last+1 node in reverse(), and return last-node(IMP it doesn't return last+1 node) 
            last.next = reverse(first, temp);
            
            // first is pointing to 1st node of group but now reversed so it became last node
            last = first;//point last node of current group, so we can next group in next iteration
            first = temp;//point to 1st node of next group
        }
        return newhead.next;
    }


    // improved reverse function
    public ListNode reverse(ListNode head, ListNode end){
        /*
        head = 1st node of group
        end = 1st node of next group
        so run the loop within the group

        Note: head should be connected to end, so use pre=end instead pre=null
        */
        ListNode temp = head;
        ListNode pre = end;//imp
        

        while(temp!=null && end!=temp ){// IMP end!=temp
            ListNode t= temp.next;
            temp.next = pre;
            pre=temp;
            
            temp=t;
        }
        return pre;
    }
}