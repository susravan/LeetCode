package LeetCodeMediumQuestions;

import java.util.Stack;

/**
 * @author Sravan
 * Created on Jan 20, 2018
 */

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 *
 */

// Inspired from
// https://leetcode.com/problems/validate-binary-search-tree/discuss/
public class ValidateBST {
	// Iterative method
	// Approach: Follow the iterative method and while doing it, update pre with
	// root => pre follows root's in order traversal but with one step later. This
	// means root's value is always greater than pre's value. Checking this
	// constraint is sufficient to validate BST. Note: Checking pre to null is
	// important
	public boolean isValidBSTIter(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> st = new Stack<>();
		TreeNode pre = null;

		while (root != null || !st.isEmpty()) {
			while (root != null) {
				st.push(root);
				root = root.left;
			}
			root = st.pop();
			// System.out.println("pre = " + (pre == null ? 0 : pre.val) + " root = " +
			// root.val);
			if (pre != null && root.val <= pre.val)
				return false;
			pre = root;
			root = root.right;
		}
		return true;
	}

	// Recursive method
	public boolean isValidBSTRecur(TreeNode root) {
		if (root == null)
			return true;

		return isValidHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidHelper(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val > min && root.val < max)
			return isValidHelper(root.left, min, root.val) && isValidHelper(root.right, root.val, max);
		else
			return false;
	}
}
