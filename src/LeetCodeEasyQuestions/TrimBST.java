package LeetCodeEasyQuestions;

import java.util.Stack;

/**
 * @author sravan created on Sep 3, 2017
 *
 */

/*
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L). You might
 * need to change the root of the tree, so the result should return the new root
 * of the trimmed binary search tree.
 * 
 * Example 1: Input: 1 / \ 0 2
 * 
 * L = 1 R = 2
 * 
 * Output: 1 \ 2 Example 2: Input: 3 / \ 0 4 \ 2 / 1
 * 
 * L = 1 R = 3
 * 
 * Output: 3 / 2 / 1
 * 
 */

public class TrimBST {

	public TreeNode TrimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;

		// Traverse the tree
		TreeNode prev = null;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);

		while(!st.isEmpty()) {
			TreeNode curr = st.pop();
			prev = curr;
			
			// Delete Node
			if(curr.val < L || curr.val > R) {
				// Case 1: Leaf Node
				if (curr.left == null && curr.right == null)
					prev = null;
	
				// Case 2: One child
				if (curr.left == null || curr.right == null) {
					if (curr.left == null) {
						curr.val = curr.right.val;
						curr.right = null;
					}
					if (curr.right == null) {
						curr.val = curr.left.val;
						curr.left = null;
					}
				}
	
				// Case 3: Two children
				TreeNode delPrev = curr;
				curr = curr.right;
				while (curr != null) {
					delPrev = curr;
					curr = curr.left;
				}
				delPrev = null;
				curr.val = curr.val;
			}
			
			
			
			
			
			if(curr.left != null)
				curr = curr.left;
			else
				root = st.pop();
			
		}
		
		// Case 1: Leaf Node
		if (root.left == null && root.right == null)
			root = null;

		// Case 2: One child
		if (root.left == null || root.right == null) {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;
		}

		// Case 3: Two children
		TreeNode prev = root;
		root = root.right;
		while (root != null) {
			prev = root;
			root = root.left;
		}
		return prev;

		return null;
	}

	private TreeNode deleteNode(TreeNode root) {
		// Case 1: Leaf Node
		if (root.left == null && root.right == null)
			return null;

		// Case 2: One child
		if (root.left == null || root.right == null) {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;
		}

		// Case 3: Two children
		TreeNode prev = root;
		root = root.right;
		while (root != null) {
			prev = root;
			root = root.left;
		}
		return prev;
	}

}
