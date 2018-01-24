package LeetCodeMediumQuestions;

import java.util.Stack;

/**
 * @author Sravan
 * Created on Jan 24, 2018
 */

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */

public class FlattenBinaryTree {
	// Recursive Approach
	public void flattenRecur(TreeNode root) {
		if (root == null)
			return;

		root = flattenHelper(root);
	}

	// Flatten left part, right part, modify pointers
	// Be careful with edge cases where left/right pointers are null
	private TreeNode flattenHelper(TreeNode root) {
		if (root.left == null && root.right == null)
			return root;

		if (root.left == null || root.right == null) {
			root.right = root.left == null ? flattenHelper(root.right) : flattenHelper(root.left);
			root.left = null;
			return root;
		}

		TreeNode leftNode = flattenHelper(root.left);
		root.right = flattenHelper(root.right);
		TreeNode temp = root.right;
		root.right = leftNode;
		TreeNode pointer = root.right;

		// Go to end of the list
		while (pointer.right != null)
			pointer = pointer.right;

		pointer.right = temp;
		root.left = null;
		return root;
	}
}
