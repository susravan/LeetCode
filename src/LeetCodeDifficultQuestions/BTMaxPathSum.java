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

// Inspired from https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/
public class BTMaxPathSum {
    // Recursive method
	int maxSum;
	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		maxPathSumHelper(root);
		return maxSum;
	}
	
	private int maxPathSumHelper(TreeNode root) {
		if(root == null)
			return 0;
		int left = maxPathSumHelper(root.left);
		int right = maxPathSumHelper(root.right);
		maxSum = Math.max(maxSum, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}
