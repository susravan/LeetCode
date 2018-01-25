package LeetCodeDifficultQuestions;

import LeetCodeDifficultQuestions.TreeNode;

/**
 * @author Sravan
 * Created on Jan 24, 2018
 */

/**
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */

// Inspired from
// https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/
public class BTMaxPathSum {
	// Recursive method
	// Global variable to have access of this over all recursions
	int maxSum;

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		maxPathSumHelper(root);
		return maxSum;
	}

	private int maxPathSumHelper(TreeNode root) {
		if (root == null)
			return 0;

		// Get max left and right sums. If negative, take 0
		int left = Math.max(0, maxPathSumHelper(root.left));
		int right = Math.max(0, maxPathSumHelper(root.right));
		// Checks paths that not necessarily start from root
		// This is the only extra step in case of looking for all paths not necessarily
		// starting from root
		maxSum = Math.max(maxSum, left + right + root.val);
		// Return the max root to leaf path sum
		return Math.max(left, right) + root.val;
	}
}
