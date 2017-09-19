package LeetCodeEasyQuestions;

/**
 * @author sravan
 * created on Aug 9, 2017
 *
 */

/* Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 *
 */


public class RemoveDuplicatesFromSortedList {

	public ListNode removeDuplicatesFromSortedList(ListNode head) {
		if(head == null || head.next == null)
            return head;
        
        ListNode curr = head;
        ListNode nextNode = head.next;
        
        while(nextNode != null) {
            if(curr.val == nextNode.val)
                curr.next = nextNode.next;
            else
                curr = curr.next;
            nextNode = curr.next;
        }
        return head;
	}

}
