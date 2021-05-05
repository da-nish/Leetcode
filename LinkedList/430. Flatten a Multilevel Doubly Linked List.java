/*
httpsleetcode.comproblemsflatten-a-multilevel-doubly-linked-list
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null) return null;
        child(head);
        return head;

    }
    
    public Node child(Node head){
        Node temp=head;
        
        //temp = main list
        //t = child list
        while(temp!=null){
            
        //case 1. when no child continue 
            if(temp.child==null){
                temp=temp.next;
                continue;
            }
            

        //case 2. when child exist
            // Tast 1. Find last node
            Node t = temp.child;
            while(t.next!=null){
                t=t.next;
            }
               
            // Task 2. add child list in main list
            
            // connect last node of child with current.next of main list
            t.next = temp.next;
            // when current.next not null set previous node
            if(temp.next!=null) temp.next.prev = t;
            
            temp.next = temp.child; // current point to child
            temp.child.prev = temp; // child point to current
            temp.child = null; //child null
            temp=temp.next; //next node
        }
        return temp;
    }
}