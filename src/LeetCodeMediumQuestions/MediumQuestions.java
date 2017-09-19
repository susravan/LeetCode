package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

// This package/ class contains most of the locked leetcode medium questions
public class MediumQuestions {

	public static void wiggleSort(int[] nums) {
		for(int i=1; i < nums.length; i += 2) {
			if(nums[i - 1] > nums[i])
				swap(nums, i - 1, i);
			if(nums[i + 1] > nums[i])
				swap(nums, i + 1, i);
		}
	}
	
	private static void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

	// Returns the level order traversal of nodes in the tree
	public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();
		ArrayList<TreeNode> currNodeList = new ArrayList<>();
		currNodeList.add(root);
		res.add(currNodeList);
		
		return null;
	}
	
	
	
	
}
