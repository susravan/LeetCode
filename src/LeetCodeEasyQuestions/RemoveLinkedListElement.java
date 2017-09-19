package LeetCodeEasyQuestions;

/**
 * @author sravan created on Aug 9, 2017
 *
 */

/*
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 *
 */

public class RemoveLinkedListElement {

	public ListNode removeLinkedListElement(ListNode head, int val) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		ListNode curr = head;

		while (curr != null) {
			if (curr.val == val)
				prev.next = curr.next;
			else
				prev = prev.next;
			curr = curr.next;
		}
		return dummyHead.next;
	}

}
