package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 9, 2017
 *
 */

/* Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 */
 
public class ReverseLinkedList {

	public ListNode reverseLinkedList(ListNode head) {
		// Iterative method - maintain 3pointers, modify the link from second to first pointer
        if(head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next;
        head.next = null;
        
        while(second != null) {
            third = third.next;
            second.next = first;
            first = second;
            second = third;
        }
        return first;
        
//         // Recursive method
//         ListNode result = reverse(head);
//         head.next = null;
//         return result;
	}
	
	private ListNode reverse(ListNode head) {
        if(head == null)
            return head;
        ListNode revNode = reverse(head.next);
        revNode.next = head;
        return head;
    }

}
