/*
https://leetcode.com/problems/copy-list-with-random-pointer/

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

Question: we need create exact copy of LL and random pointer must point to newly created LL

Note: 

    create copy of original/old LL
    map(old node, new node)
    to find random pointer of new LL: map.get(old node.random)

*/

class Solution {
    public Node copyRandomList(Node head) {
        //using fake head technique;
        Node fh = new Node(-1);
        Node t = fh;
        Node temp=head;

        Map<Node,Node> map = new HashMap<>();
        map.put(null, null);//imp when node point to null;

        //create node, copy value, set next pointer
        //mapping old ll with new ll
        while(temp!=null){
            t.next = new Node(temp.val);
            t=t.next;
            map.put(temp, t);
            temp=temp.next;
        }
        
        //getting random pointer of new ll with the help old ll using HashMap
        temp=head;
        t=fh.next;
        while(temp!=null){
            t.random = map.get(temp.random); 
            //temp.random return X node of old LL and that X node is corresponding to X node new LL
            
            t=t.next;
            temp=temp.next;
        }
        
        
        
        return fh.next;
    }
}