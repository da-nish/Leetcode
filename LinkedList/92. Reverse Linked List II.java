/**
https://leetcode.com/problems/reverse-linked-list-ii/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


/*
Note:
    find previous of left node
    find right node

    create reverse function which takes (left-node and right-next-node) returns first node of reversed LL

    if(left==1) head = (head, right)//first node is include 

    left.next = reverse(left.next, right)


edge cases:
    left==right, return head
    head is null, return head
    head.next is null, return head

    head node is inclusive
    tail node is inclusive

*/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left == right) return head; 
        
        ListNode temp = head;
        ListNode l = head;
        ListNode r = head;
        int i=1;


        while(temp!=null){
            //find previous of left-index node
            if(i==left-1) l = temp;

            //find right-index node
            if(i==right) {
                r = temp;
                break;
            }
            
            temp=temp.next;
            i++;
        }
        
        //left==1 when first node is include, he did not find previous of first node
        //pass head to reverse from first node    
        if(left==1)
            head reverse(head, r.next);//it will return first node of reversed LL
     
        //connect previous node of left-index with first node of reverse LL
        l.next = reverse(l.next, r.next);//it will return first node of reversed LL

        return head;
        
    }
    

    //normal reverse method
    public ListNode reverse(ListNode head, ListNode last){
        ListNode temp = head;
        ListNode end = last;
        while(temp!=null && end!=temp){
            ListNode t = temp.next;
            temp.next = last;
            last = temp;
            
            temp=t;
        }
        
        
        return last;
    }
}