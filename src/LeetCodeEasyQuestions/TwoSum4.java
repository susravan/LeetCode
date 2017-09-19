package LeetCodeEasyQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author sravan
 * created on Aug 7, 2017
 *
 */

/* Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 *
 */

// Inspired from https://leetcode.com/problems/two-sum-iv-input-is-a-bst/solution/

public class TwoSum4 {

	public boolean findTarget(TreeNode root, int k) {
		// Approach - InOrder traversal and then find 2 elements for the sum
        // Another approach is to do BFS and while traversing maintain a hashset and check for it's complement in the set
        // First approach is implemented here
        List<Integer> list = new ArrayList<>();
        getInorderTraversal(root, list);
        int start = 0, end = list.size() - 1;
        
        while(start < end) {
            int first = list.get(start), second = list.get(end);
            if(first + second == k)
                return true;
            else if(first + second < k)
                start++;
            else
                end--;
        }
        return false;
        
        // //Third Approach
        // HashSet<Integer> set = new HashSet<>();
        // return findTargetHelper(root, set, k);
	}
	
	private void getInorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        getInorderTraversal(root.left, list);
        list.add(root.val);
        getInorderTraversal(root.right, list);
    }

	private boolean findTargetHelper(TreeNode root, HashSet<Integer> set, int target) {
        if(root == null)
            return false;
        if(set.contains(target - root.val))
            return true;
        set.add(root.val);
        return findTargetHelper(root.left, set, target) || findTargetHelper(root.right, set, target);
    }
}
