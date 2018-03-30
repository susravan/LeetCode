package LeetCodeMediumQuestions;

import java.util.Stack;

/**
 * @author Sravan
 * Created on Mar 30, 2018
 */

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * 
 */

// Inspired from
public class BinarySearchTreeIterator {
	Stack<TreeNode> st;
	TreeNode currNode;

	public BinarySearchTreeIterator(TreeNode root) {
		st = new Stack<>();
		currNode = null;
		TreeNode node = root;
		while (node != null) {
			st.push(node);
			node = node.left;
		}
		currNode = st.isEmpty() ? null : st.pop();
	}

	public boolean hasNext() {
		return currNode != null;
	}

	public TreeNode getNext() {
		if (currNode == null)
			throw new NullPointerException();

		TreeNode res = currNode;
		currNode = currNode.right;
		while (currNode != null) {
			st.push(currNode);
			currNode = currNode.left;
		}
		currNode = st.isEmpty() ? null : st.pop();
		return res;
	}
}
