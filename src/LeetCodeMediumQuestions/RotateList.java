package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 9, 2017
 *
 */

/* Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL
 *
 */

public class RotateList {

	public ListNode rotateList(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		// Get length of the list
		ListNode curr = head;
		int len = 0;
		while (curr != null) {
			curr = curr.next;
			len++;
		}
		// If k > len, make it less than length
		k = k % len;

		if (k == 0)
			return head;

		ListNode prev = new ListNode(0);
		prev.next = head;
		ListNode left = head;
		ListNode right = head;

		// Getting the range of the shift
		while (k > 1) {
			right = right.next;
			k--;
		}
		// Moving the range rightwards
		while (right.next != null) {
			prev = prev.next;
			left = left.next;
			right = right.next;
		}

		prev.next = null;
		right.next = head;
		head = left;
		return head;
	}

}
