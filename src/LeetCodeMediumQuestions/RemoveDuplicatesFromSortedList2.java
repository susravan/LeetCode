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
		// Approach - Maintain prev pointer inorder to remove the curr node if its duplicate
        // Maintain boolean del to store if curr is repeated or not
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		ListNode curr = head;
		ListNode nextNode = curr;
		boolean del = false;

		while (curr != null) {
			nextNode = nextNode.next;
			// Delete all adjacent duplicates
            // del = true iff curr.val is repeated in the list
			while (nextNode != null && curr.val == nextNode.val) {
				curr.next = nextNode.next;
				nextNode = nextNode.next;
				del = true;
			}
			if (del) {
				prev.next = curr.next;
				curr = curr.next;
				del = false;
			} else {
				prev = prev.next;
				curr = curr.next;
			}
		}
		return dummyHead.next;
	}

}
