/**
 * https://leetcode.com/problems/add-two-numbers-ii/submissions/

Note: Add to numbers(from right side)
    reverse both lists and perform Add to numbers(from left side)
    reverse again and return

 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if(l1==null || l2==null) return 
        l1=rev(l1);
        l2=rev(l2);
        ListNode t1=l1;
        ListNode t2=l2;
        
        int c=0;
        while(t1!=null && t2!=null){
            
            int sum = t1.val+t2.val+c;
            c=sum/10;
            t1.val=sum%10;
            
            if(t1.next==null && t2.next==null && c==1){
                t1.next = new ListNode(c);
                t1=t1.next;
                c=0;
                break;
            }
            else if(t1.next==null){
                t1.next = t2.next;
                t1=t1.next;
                break;
            }
            else if(t2.next==null){
                t1=t1.next;
                break;
            }
            else{
                t1=t1.next;
                t2=t2.next;
            }
        }
        
        while(t1!=null && c==1){
            int sum = t1.val+c;
            c=sum/10;
            t1.val=sum%10;
            
            if(t1.next==null && c==1){
                t1.next = new ListNode(c);
                t1=t1.next;
                c=0;
                break;
            }
            
            t1=t1.next;
        } 
        return rev(l1);
 
    }
    
    public ListNode rev(ListNode head){
        ListNode temp = head;
        ListNode pre = null;
        
        while(temp!=null){
            ListNode t = temp.next;
            temp.next = pre;
            pre=temp;
            
            temp=t;
        }
        return pre;
    }
}