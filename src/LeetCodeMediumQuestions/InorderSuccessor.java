package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Feb 28, 2018
 */

/**
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 */

// Inspired from
public class InorderSuccessor {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (root.val <= p.val)
			return inorderSuccessor(root.right, p);
		else {
			TreeNode left = inorderSuccessor(root.left, p);
			return left == null ? root : left;
		}
	}
}
