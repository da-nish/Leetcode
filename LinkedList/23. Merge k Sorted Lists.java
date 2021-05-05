/**
https://leetcode.com/problems/merge-k-sorted-lists/submissions/

Note: create merger function that merge two lists, pass two lists each time but Not efficient
    
use priority queue (efficient)


 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        
        ListNode re=lists[0];
        
        for(int i=1; i<lists.length; i++){
             re = merge(re, lists[i]);
        }
        return re;
    }
    
    
    public ListNode merge(ListNode fr, ListNode sc){
        if(fr==null) return sc;
        if(sc==null) return fr;
        
        ListNode fhead = new ListNode(-1);
        ListNode t = fhead;
        while(fr!=null && sc!=null){
            
            if(fr.val<sc.val){
                t.next = fr;
                t=fr;
                fr = fr.next;
            }
            else{
                t.next = sc;
                t=sc;
                sc = sc.next;
            }
        }
        
        while(fr!=null){
            t.next = fr;
            t=fr;
            fr=fr.next;
        }
        
        while(sc!=null){
            t.next = sc;
            t=sc;
            sc=sc.next;
        }
               
        t.next = null;
        
        return fhead.next;
    }
}