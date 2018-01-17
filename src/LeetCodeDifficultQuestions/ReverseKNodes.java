package LeetCodeDifficultQuestions;

/**
 * @author Sravan 
 * Given a linked list, reverse the nodes of a linked list k at a
 *         time and return its modified list.
 * 
 *         k is a positive integer and is less than or equal to the length of
 *         the linked list. If the number of nodes is not a multiple of k then
 *         left-out nodes in the end should remain as it is.
 * 
 *         You may not alter the values in the nodes, only nodes itself may be
 *         changed.
 * 
 *         Only constant memory is allowed.
 * 
 *         For example, Given this linked list: 1->2->3->4->5
 * 
 *         For k = 2, you should return: 2->1->4->3->5
 * 
 *         For k = 3, you should return: 3->2->1->4->5
 * 
 * 
 * 
 */

public class ReverseKNodes {
	public ListNode reverseKGroup(ListNode head, int k) {
		// Approach: Similar to swap 2 nodes except reverse function should be taken care of
		// Be careful of edge cases like when the list has 9 elements and k=10/ k=8/ k=1 etc.
		
		if (k == 1)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, slow = dummy.next, curr = slow, fast;

		while (curr != null && curr.next != null) {
			fast = slow;
            // Putting count=1 as we should count the current fast node also
			int len = 1;
			// IMPORTANT: .next is necessary here. Checking for fast node as null
			// means counting the null node also
			while (fast.next != null && len < k) {
				fast = fast.next;
				len++;
			}
			// System.out.println("Current length = " + len);
			if (len == k) {
				ListNode temp = fast == null ? fast : fast.next;
				prev.next = reverse(slow, fast);
				// System.out.println("After reversing the linked list, starting pointer = " +
				// prev.next.val);
				while (prev.next != null) {
					prev = prev.next;
				}
				prev.next = temp;
				slow = prev.next;
				curr = temp;
			} else
				break;
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode first, ListNode last) {
		ListNode dummy = new ListNode(0);
		dummy.next = first;
		ListNode curr = first.next, temp;

		// Similar to normal reverse except that instead of checking for null, 
		// check for last node 
		while (curr != last) {
			temp = curr.next;
			curr.next = first;
			first = curr;
			curr = temp;
		}
		curr.next = first;
		dummy.next.next = null;
		return curr;
	}
}
