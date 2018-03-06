package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Mar 5, 2018
 */

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
 */

// Inspired from 
public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null)
			return null;

		// Dont forget to initialize with nulls
		TreeNode prev = null;
		TreeNode curr = root;
		TreeNode temp = null;
		TreeNode next;

		while (curr != null) {
			next = curr.left;
			curr.left = temp;
			temp = curr.right;
			curr.right = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
