package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sravan
 * created on Aug 5, 2017
 *
 */

/*  Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

	Two trees are duplicate if they have the same structure with same node values.
 *
 */


public class FindDuplicateSubTrees {

	public List<TreeNode> FindDuplicateSubTrees(TreeNode root) {
		HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        findDuplicatesHelper(root, map, res);
        return res;
	}
	
	private String findDuplicatesHelper(TreeNode root, HashMap<String, Integer> map, List<TreeNode> res) {
        if(root == null)
            return "";
        
        String left = findDuplicatesHelper(root.left, map, res);
        String right = findDuplicatesHelper(root.right, map, res);
        // Even making the key is important as making this way can get you duplicates --> left + "L" + root.val + "R" + right
        String key = "L" + left + root.val + "R" + right;
        System.out.println("Current key = " + key);
        if(!map.containsKey(key))
            map.put(key, 0);
        else {
            if(map.get(key) == 0) {
                map.put(key, 1);
                res.add(root);
            }
        }
        return key;
    }
}
