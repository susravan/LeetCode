package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 26, 2018
 */

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 */

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null)
			return;

		// Find mid and reverse
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = reverse(slow.next);

		// Alternate first and reversed part of lists
		ListNode left = head, leftNext;
		ListNode right = slow, rightNext;

		while (right.next != null) {
			rightNext = right.next.next;
			leftNext = left.next;
			left.next = right.next;
			right.next.next = leftNext;
			right.next = rightNext;
			left = left.next.next;
		}
	}

	// Reverse the linked list
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = head;
		ListNode ahead = head.next;

		while (ahead != null) {
			curr.next = prev;
			prev = curr;
			curr = ahead;
			ahead = ahead.next;
		}
		curr.next = prev;
		head.next = null;
		return curr;
	}
}
