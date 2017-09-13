package LeetCodeMediumQuestions;

/**
 * @author sravan created on Sep 12, 2017
 *
 */

/*
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 *
 * 
 * 
 */


public class DeleteNthNodeFromLast {

	public ListNode deleteNthNodeFromLast(ListNode head, int n) {
		// Having dummy node helps in many ways
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;

		ListNode first = dummyNode;
		ListNode second = dummyNode;

		while (n != 0) {
			second = second.next;
			n--;
		}

		while (second.next != null) {
			first = first.next;
			second = second.next;
		}
		first.next = first.next.next;
		return dummyNode.next;
	}

}
