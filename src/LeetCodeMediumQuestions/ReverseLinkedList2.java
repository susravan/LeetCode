package LeetCodeMediumQuestions;

/**
 * @author sravan created on Aug 9, 2017
 *
 */

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 *
 */

public class ReverseLinkedList2 {

	public ListNode reverseLinkedList2(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n)
			return head;

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;

		ListNode prev = dummyNode;
		ListNode mPointer = head;
		while (m > 1) {
			prev = mPointer;
			mPointer = mPointer.next;
			m--;
		}
		ListNode nPointer = head;
		while (n > 1) {
			nPointer = nPointer.next;
			n--;
		}

		ListNode nextPointer = nPointer.next;
		nPointer.next = null;
		ListNode revList = reverseList(mPointer);
		prev.next = revList;
		// Append second part of the linked list
		while (prev.next != null)
			prev = prev.next;
		prev.next = nextPointer;
		return dummyNode.next;
	}

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = head;
		ListNode mid = head.next;
		ListNode nextNode = head.next;
		while (nextNode != null) {
			// This statement should be first statement inside while loop
			// because of the condition
			// in the while loop
			nextNode = nextNode.next;
			mid.next = prev;
			prev = mid;
			mid = nextNode;
		}
		head.next = null;
		return prev;
	}
}
