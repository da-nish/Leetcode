/**
 * https://leetcode.com/problems/linked-list-components/
 Prolem explain: https://leetcode.com/problems/linked-list-components/discuss/131853/Can-someone-explain-the-test-case/167790
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        if(G.length==0 || head==null) return 0;
        
        Set<Integer> set= new HashSet<>();
        
        for(int i:G) set.add(i);
        
        ListNode temp = head;
        int re = 0;
        int c=0;
        
        while(temp!=null){

            //continous value are one component
            if(set.contains(temp.val)){
                c++;
            }
            //curr.val is not in set, update result, and set component len=0;
            else if(c>0){
                re++;
                c=0;
            }
            temp=temp.next;
        }
        //when last node contain component value
        if(c>0) re++;
        
        return re;
    }
}