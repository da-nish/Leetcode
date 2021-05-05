/**

https://leetcode.com/problems/split-linked-list-in-parts/

https://leetcode.com/problems/split-linked-list-in-parts/discuss/385685/Java%3A-0-ms-faster-than-100.00-(with-comments)

*/
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] ar=new ListNode[k];
        ListNode temp=root;
        
        //find length
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }


        int parts = len/k;//number of parts
        int extra = len%k;//number of extra node
        int index =0;//result array index
        

        temp=root;
        while(temp!=null){
           ListNode t=temp;//head of part
           
           //add extra either 1:0 
           int addextra = extra<=0 ? 0:1;
           //0 to parts 
           for(int i=0; i<parts+addextra-1; i++){
               t=t.next;
           }
           /*
              when addextra=1
              (0,1)<2+1-1 (consider 0 and 1 node) 
              IMP t=t.next in the second iteration t point to third, so third node also considered 
          
              when addextra=0
              (0)<2+0-1 (consider 0 node) 
              IMP t=t.next in the first iteration t point to second, so only nodes are consider

          */
           ListNode nextPart = t.next;
           t.next =null;

           //setting in array
           ar[index++]=temp;

           temp=nextPart;
           
           extra--;//decrease extra node
       }
        return ar;
    }
}