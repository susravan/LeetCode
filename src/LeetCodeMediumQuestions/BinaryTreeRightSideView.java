package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sravan
 * Created on Jan 28, 2018
 */

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 *
 */

public class BinaryTreeRightSideView {
	public List<Integer> rightSideViewRecur(TreeNode root) {
		// Recursive approach
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		rightViewHelper(res, root, 1, 0);
		return res;
	}

	private int rightViewHelper(List<Integer> res, TreeNode root, int level, int maxLevel) {
		if (root == null)
			return maxLevel;

		if (root.left == null && root.right == null) {
			if (level > maxLevel) {
				res.add(root.val);
				return level;
			}
			return maxLevel;
		}

		if (level > maxLevel) {
			res.add(root.val);
		}
		maxLevel = Math.max(level, maxLevel); // Max. level that have seen till now
		maxLevel = rightViewHelper(res, root.right, level + 1, maxLevel);
		maxLevel = rightViewHelper(res, root.left, level + 1, maxLevel);
		return maxLevel;
	}
}
