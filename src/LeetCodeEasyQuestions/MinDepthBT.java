package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 22, 2018
 */

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */

// Inspired from
public class MinDepthBT {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		return minDepthHelper(root);
	}
	
	// Be careful when one of the nodes is null
	private int minDepthHelper(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null)
			return minDepthHelper(root.right) + 1;
		if (root.right == null)
			return minDepthHelper(root.left) + 1;
		return 1 + Math.min(minDepthHelper(root.left), minDepthHelper(root.right));
	}
}
