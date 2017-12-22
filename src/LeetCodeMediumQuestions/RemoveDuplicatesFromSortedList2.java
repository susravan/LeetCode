package LeetCodeMediumQuestions;

/**
 * @author sravan created on Aug 9, 2017
 *
 */

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 *
 */

public class RemoveDuplicatesFromSortedList2 {

	public ListNode removeDuplicatesFromSortedList2(ListNode head) {
		// Subtle approach with minimum number of steps
		if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null) {
            while(curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if(prev.next==curr){
                prev=prev.next;
            }
            else{
                prev.next=curr.next;
            }
            curr=curr.next;
        }
        return dummy.next;
	}

}
