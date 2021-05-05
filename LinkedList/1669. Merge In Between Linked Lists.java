/**
https://leetcode.com/problems/merge-in-between-linked-lists/

Note:

    //insertion is based on index number Not node.val
 

*/
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = null;
        ListNode right = null;
        ListNode temp= list1;
        ListNode last= null;
        int i=0;
        while(temp!=null){

            //previous of left node
            if(a==i) left=last;
            //curr of right node
            if(b==i) right=temp;

            i++;
            last = temp;
            temp=temp.next;
        }
        
        ListNode l2l = list2;
        while(l2l!=null){
            //finding last node of second list
            if(l2l.next==null) break;
            l2l=l2l.next;
        }
        
        //if insert from first node
        //point list2
        if(left==null)  list1=list2;

        else left.next=list2;//previous of left connect to list2
        l2l.next=right.next;//last of list2 connect to next of right node
        

        return  list1;
        
    }
}