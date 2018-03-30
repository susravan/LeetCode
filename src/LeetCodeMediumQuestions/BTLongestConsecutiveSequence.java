package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Mar 29, 2018
 */

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */

// Inspired from 
public class BTLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, 1, 1);
	}

	private int helper(TreeNode root, int prev, int currMax, int max) {
		if (root == null) {
			max = Math.max(currMax, max);
			return max;
		}

		int leftMax = helper(root.left, root.val, root.val == (prev + 1) ? currMax + 1 : 1, max);
		int rightMax = helper(root.right, root.val, root.val == (prev + 1) ? currMax + 1 : 1, max);
		max = Math.max(Math.max(leftMax, rightMax), max);
		return max;
	}
}
