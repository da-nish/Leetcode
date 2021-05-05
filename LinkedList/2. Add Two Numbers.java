/**
https://leetcode.com/problems/add-two-numbers/
Add to numbers(from left side)

Short Note: loop-1 run l1 and l2 simultaneouly and add value, store carry, 
            if it is end of any list Break the loop
            for single list iteration, we use loop-2
            use if-else for update and break

            loop-2 run only sinlge list and when carry==1

            imp: when last node check carry==1 then add new node;

Note:
    loop 1 - run l1 and l2 
        
        < find sum, carry and set value >

        if(both end same time AND carry==1)
            add new node(c)
            c=0; set carry
            break loop;
        elif(l1 end)
            l1.next = l2.next;//connect to l2 list(l2.next because current is processed)
            break loop;
        elif(l2.end)
            l1.next = l1.next;//continue with l1
            break loop;
        else
            l1=l1.next;
            l2=l2.next;

    loop 2 - run l1 and c==1
            < find sum, carry and set value >
            if(next is end AND carry==1)
                add new node(c)
                break loop;
        
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode t1 = l1;
        ListNode t2 = l2;
        int c=0; //carry

        // l1 will be the resultant list;

        while(t1!=null && t2!=null){
            
            int sum = t1.val+t2.val+c;
            c = sum/10; //finding carry
            t1.val = sum%10;//stroing last digit

            //when same length but carry remains, ex [5][5] => [0,1]
            //create new node at the end
            if(t1.next==null && t2.next==null && c==1){
                t1.next = new ListNode(1);
                c=0; //carry used, set zero
                break;   
            }

            //when t1 is smaller, point to t2
            else if(t1.next==null){
                t1.next = t2.next; //either t2.next is null or a node
                t1=t1.next; // update to set carry in remaining nodes
                break;   
            }

            //when t2 is smaller, continue with t1
            else if(t2.next==null){
                t1=t1.next;
                break;
            }

            //update condition
            else{
                t1 = t1.next;
                t2 = t2.next;
            }
            
        }
        //now t1 is pointing t1 or t2(which one was larger)
        //run only when c==1 
        while(t1!=null && c==1){
            int sum = t1.val+c;
            c = sum/10;
            t1.val = sum%10;

            //create new node at the end
            if(t1.next==null && c==1){
                t1.next = new ListNode(1);
                c=0;
                break;
            }
            t1 = t1.next;
        }
        
        return l1;
    }
}