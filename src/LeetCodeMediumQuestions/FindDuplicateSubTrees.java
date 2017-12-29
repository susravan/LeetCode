package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sravan created on Aug 5, 2017
 * 		   Given a binary tree, return all
 *         duplicate subtrees. For each kind of duplicate subtrees, you only
 *         need to return the root node of any one of them.
 * 
 *         Two trees are duplicate if they have the same structure with same
 *         node values.
 *
 */

public class FindDuplicateSubTrees {

	public List<TreeNode> FindDuplicateSubTrees(TreeNode root) {
		Set<String> set = new HashSet<>();
		List<TreeNode> res = new ArrayList<>();
		findDuplicatesHelper(root, set, res);
		return res;
	}

	private String findDuplicatesHelper(TreeNode root, Set<String> set, List<TreeNode> res) {
		if (root == null)
			return "";

		String left = findDuplicatesHelper(root.left, set, res);
		String right = findDuplicatesHelper(root.right, set, res);
		// Even making the key is important as making this way can get you duplicates
		// --> left + "L" + root.val + "R" + right
		String key = "L" + left + root.val + "R" + right;
		System.out.println("Current key = " + key);
		if (!set.contains(key))
			set.add(key);
		else
			res.add(root);
		return key;
	}
}
