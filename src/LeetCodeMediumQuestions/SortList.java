package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 9, 2017
 *
 */

/*  Sort a linked list in O(n log n) time using constant space complexity.
 *
 */


public class SortList {

	public ListNode sortList(ListNode head) {
		// Approach - Do merge sort by dividing the list into 2 parts and merging them once sorted
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        
        // Divide the main list into 2 equal halfs
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        // Sort left and right lists
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        // Merging two sorted lists
        return merge(left, right);
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummyHead = head;
        
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            }
            else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        if(l1 == null)
            head.next = l2;
        if(l2 == null)
            head.next = l1;
        
        return dummyHead.next;
    }

}
