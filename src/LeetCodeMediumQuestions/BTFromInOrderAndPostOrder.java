package LeetCodeMediumQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sravan
 * Created on Jan 21, 2018
 */

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * 
 */

public class BTFromInOrderAndPostOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			inorderMap.put(inorder[i], i);

		return buildTreeHelper(inorder, postorder, inorderMap, 0, inorder.length - 1, postorder.length - 1);
	}

	private TreeNode buildTreeHelper(int[] inorder, int[] postorder, Map<Integer, Integer> map, int inStart, int inEnd,
			int postIndex) {
		if (inStart > inEnd || postIndex < 0)
			return null;

		int currIndex = map.get(postorder[postIndex]);
		int rightTreelen = inEnd - currIndex;
		TreeNode root = new TreeNode(inorder[currIndex]);
		root.right = buildTreeHelper(inorder, postorder, map, currIndex + 1, inEnd, postIndex - 1);
		root.left = buildTreeHelper(inorder, postorder, map, inStart, currIndex - 1, postIndex - rightTreelen - 1);
		return root;
	}
}
