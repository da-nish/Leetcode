/**
 *
 *https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * 
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Node pre = head;//first node

		// if empty linkedlist;
		if(pre==null) return head;

		Node t = head.next; //second node

		while(t != null){
			//use if-else for case like 1,1,1,1,2

			if(pre.data == t.data){
				pre.next = t.next;//temp next
				t = t.next;//self next
			}
			else{
				t = t.next;//self next
				pre = pre.next;//self next
			}
		}
    }
}