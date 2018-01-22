package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 22, 2018
 */

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 */

// Inspired from https://leetcode.com/problems/balanced-binary-tree/discuss/
public class BalancedBT {
	// Approach: DFS ***O(N) complexity***. Traversing the tree by DFS and checking
	// the balance of the tree at the same time from bottom-top approach
	// Can also be done in top-bottom approach which takes O(N^2) as compared to O(N) in this approach
	public boolean isBalanced(TreeNode root) {
        return dfsIsBalancedHelper(root) != -1;
    }

	// Returns -1 if a subtree is not balanced, returns the current node's max
	// height if balanced
	private int dfsIsBalancedHelper(TreeNode root) {
		if (root == null)
			return 0;

		int left = dfsIsBalancedHelper(root.left);
		if (left == -1)
			return -1;
		int right = dfsIsBalancedHelper(root.right);
		if (right == -1)
			return -1;

		if (Math.abs(left - right) > 1)
			return -1;
		return 1 + Math.max(left, right);
	}
}
