package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 21, 2018
 */

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */


public class SortedListBinaryTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		return helper(head, null);
	}

	private TreeNode helper(ListNode head, ListNode tail) {
		if (head == tail)
			return null;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = helper(head, slow);
		root.right = helper(slow.next, tail);
		return root;
	}
}