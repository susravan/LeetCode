package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 9, 2017
 *
 */

/* Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 */


public class SwapNodesInPairs {

	public ListNode swapNodesInPairs(ListNode head) {
		if(head == null || head.next == null)
            return head;
        
//        // Recursive approach - call the method recursively every 2 nodes
//        // Modify the sequence of first two nodes and link the output of the result
//        ListNode swappedSeq = swapNodesInPairs(head.next.next);
//        ListNode res = head.next;
//        head.next.next = head;
//        head.next = swappedSeq;
//        return res;
		
		// Iterative approach - Useful when the list is very long
        ListNode first = head;
        ListNode mid = head.next;
        ListNode sec = mid;
        head = mid;
        
        while(sec != null) {
            sec = sec.next;
            mid.next = first;
            if(sec == null || sec.next == null)
                first.next = sec;
            else
                first.next = sec.next;
            first = sec;
            if(first == null)
                return head;
            mid = first.next;
            sec = mid;
        }
        return head;
	}

}
