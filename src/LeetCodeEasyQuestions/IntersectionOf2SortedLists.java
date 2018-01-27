package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 27, 2018
 */

/**Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */

public class IntersectionOf2SortedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode pointer1 = headA, pointer2 = headB;
		int len1 = 1, len2 = 1;

		while (pointer1 != null) {
			pointer1 = pointer1.next;
			len1++;
		}

		while (pointer2 != null) {
			pointer2 = pointer2.next;
			len2++;
		}
		int diff = Math.abs(len1 - len2);

		// Greater length list is pointed by pointer1
		pointer1 = len1 > len2 ? headA : headB;
		pointer2 = len1 > len2 ? headB : headA;

		while (diff > 0 && pointer1 != null) {
			pointer1 = pointer1.next;
			diff--;
		}

		while (pointer1 != null && pointer2 != null) {
			if (pointer1 == pointer2)
				return pointer1;
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return null;
	}
}
