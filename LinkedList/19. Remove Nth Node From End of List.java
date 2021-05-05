/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

solution 1. reverse the array and remove nth node from left side
solution 2. find length and remove len-nth node

*/
class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode temp = A;
        ListNode last = null;
        
        int len= len(A);
        if(len<B) return A;
        if(len==B) return A.next;
        
        
        // [ 1 -> 2 -> 3 -> 4 -> 5 ]
        int i=1;
        while(temp!=null){
            
            if(i++== len-B){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return A;  
    }
    
    public static int len(ListNode root){
        
        int i=0;
        while(root!=null){
            i++;
            root = root.next;
        }
        return i;
    }
}