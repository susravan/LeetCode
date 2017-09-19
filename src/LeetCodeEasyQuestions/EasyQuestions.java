package LeetCodeEasyQuestions;

import java.util.ArrayList;
import java.util.List;

import tree.*;

public class EasyQuestions {

	// https://leetcode.com/problems/merge-two-binary-trees/#/description
	public static Node mergeTrees(Node root1, Node root2) {
		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;
		
		Node newRoot = new Node(root1.data + root2.data);
		newRoot.left = mergeTrees(root1.left, root2.left);
		newRoot.right = mergeTrees(root1.right, root2.right);
		return newRoot;
	}
	
	// General print method
	public static void printTree(Node root) {
		// Inorder traversal
		if (root != null) {
			printTree(root.left);
			System.out.print(root.data + ",");
			printTree(root.right);
		}

		// // Pre-order traversal
		// if(root!=null) {
		// System.out.print(root.data+",");
		// printTree(root.left);
		// printTree(root.right);
		// }

		// // Post-order traversal
		// if(root!=null) {
		// printTree(root.left);
		// printTree(root.right);
		// System.out.print(root.data+",");
		// }
	}
	
	public static ArrayList<Integer> getLeftView(Node root) {
		int maxDepth = Integer.MIN_VALUE, currDepth = 0;
		ArrayList<Integer> result = new ArrayList<>();
		addLeftMost(root, result, currDepth, maxDepth);
		return result;
	}
	
	private static int addLeftMost(Node root, List<Integer> result, int currDepth, int maxDepth) {
		if(root == null)
			return maxDepth;
		
		// Add node only if the current depth is greater than that already seen maxDepth
		if(currDepth > maxDepth) {
			result.add(root.data);
			maxDepth = currDepth;
		}
		
		// This order of calling left and then right inherently takes care of adding only leftmost nodes
		// Changing this to right makes the problem output all the nodes seen from right side
		maxDepth = addLeftMost(root.left, result, currDepth + 1, maxDepth);
		maxDepth = addLeftMost(root.right, result, currDepth + 1, maxDepth);
		return maxDepth;
	}
}