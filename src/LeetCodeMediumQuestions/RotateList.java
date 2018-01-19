package LeetCodeMediumQuestions;

/**
 * @author sravan created on Aug 9, 2017
 *
 */

/*
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL
 *
 */

// Inspired from https://leetcode.com/submissions/detail/136891689/
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;

		ListNode first = head, second = head;
		int i = 0;
		while (i < k) {
			if (first.next != null) {
				first = first.next;
				i++;
			} else
				break;
		}

		// Check if k nodes are reached or "first" node is null
		if (i < k) {
			i++;
			// Checking if k == length of the list, if so return head
			if (i == k)
				return head;
			// else get new k and use it to shift the pointers
			int shift = k % i;
			first = head;
			for (int j = 0; j < shift; j++)
				first = first.next;
		}

		while (first.next != null) {
			first = first.next;
			second = second.next;
		}

		first.next = head;
		head = second.next;
		second.next = null;

		return head;
	}
}
