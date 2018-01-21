package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 21, 2018
 */

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 *
 */

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode leftDummy = new ListNode(0);
		ListNode midDummy = new ListNode(0);
		ListNode rightDummy = new ListNode(0);
		ListNode left = leftDummy, mid = midDummy, right = rightDummy;

		while (head != null) {
			if (head.val < x) {
				System.out.println("left = " + head.val);
				left.next = new ListNode(head.val);
				left = left.next;
			} else if (head.val == x) {
				mid.next = new ListNode(head.val);
				mid = mid.next;
			} else {
				System.out.println("right = " + head.val);
				right.next = new ListNode(head.val);
				right = right.next;
			}
			head = head.next;
		}
		right.next = null;
		left.next = midDummy.next;
		mid.next = rightDummy.next;

		return leftDummy.next;
	}
}
