package LeetCodeMediumQuestions;

import java.util.Stack;

/**
 * @author Sravan
 * Created on Jan 29, 2018
 */

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 */

public class BSTIterator {

	private TreeNode minNode;
	Stack<TreeNode> st;

	public BSTIterator(TreeNode root) {
		minNode = root;
		st = new Stack<>();

		while (minNode != null) {
			st.push(minNode);
			minNode = minNode.left;
		}
		if (!st.isEmpty())
			minNode = st.pop();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return minNode != null;
	}

	/** @return the next smallest number */
	public int next() {
		if (minNode == null)
			return -1;

		int res = minNode.val;

		if (minNode.right == null) {
			if (st.isEmpty())
				minNode = null;
			else {
				minNode = st.pop();
			}
		} else {
			minNode = minNode.right;
			while (minNode != null) {
				st.push(minNode);
				minNode = minNode.left;
			}
			if (!st.isEmpty())
				minNode = st.pop();
		}
		return res;
	}
}
