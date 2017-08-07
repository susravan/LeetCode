package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 6, 2017
 *
 */

/*  Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 *
 */


public class OddEvenLinkedList {

	public ListNode alternateLinkedList(ListNode head) {
		if(head == null || head.next == null)
            return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenDup = even;
        // Remember this condition - no need to put another 2 conditions for odd pointer
        // as even != null convers odd.next != null and vice versa
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenDup;
        return head;
	}

}
