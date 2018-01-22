package LeetCodeMediumQuestions;

import java.util.HashMap;
import java.util.Map;
import LeetCodeMediumQuestions.TreeNode;

/**
 * @author Sravan
 * Created on Jan 21, 2018
 */

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */

public class BTFromInOrderAndPreOrder {
	// Approach: Preorder traversal gives the root of the tree and inorder traversal
	// gives the left and right subtrees
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			inorderMap.put(inorder[i], i);

		return buildTreeHelper(preorder, inorder, inorderMap, 0, inorder.length - 1, 0);

	}

	// HashMap is used to reduce the time complexity from worst case O(n^2) to O(n)
	private TreeNode buildTreeHelper(int[] preorder, int[] inorder, Map<Integer, Integer> map, int inStart, int inEnd,
			int preStart) {
		if (inStart > inEnd)
			return null;

		int currIndex = map.get(preorder[preStart]);
		int leftTreeLen = currIndex - inStart;
		TreeNode root = new TreeNode(inorder[currIndex]);
		root.left = buildTreeHelper(preorder, inorder, map, inStart, currIndex - 1, preStart + 1);
		root.right = buildTreeHelper(preorder, inorder, map, currIndex + 1, inEnd, preStart + leftTreeLen + 1);
		return root;
	}
}
