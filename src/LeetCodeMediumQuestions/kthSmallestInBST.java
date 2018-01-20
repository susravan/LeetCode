package LeetCodeMediumQuestions;

import java.util.Stack;

/**
 * @author Sravan created on Aug 5, 2017
 *
 */

/*
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ? k ? BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 *
 */

// Inspired from
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/

public class kthSmallestInBST {
	public int kthSmallest(TreeNode root, int k) {
		// Iterative way - Do inorder traversal and return the kth node in the process
		if (root == null || k == 0)
			return Integer.MAX_VALUE;

		Stack<TreeNode> st = new Stack<>();

		while (root != null || !st.isEmpty()) {
			while (root != null) {
				st.push(root);
				root = root.left;
			}
			root = st.pop();
			// Either "k-- == 1" or "--k == 0"
			if (--k == 0)
				return root.val;
			root = root.right;
		}
		return Integer.MAX_VALUE;
	}
}
