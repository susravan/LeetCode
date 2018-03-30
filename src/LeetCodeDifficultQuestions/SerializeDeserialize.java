package LeetCodeDifficultQuestions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sravan
 * Created on Mar 29, 2018
 */

/**
 *Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

// Inspired from 
public class SerializeDeserialize {
	private final String delimitter = ",";
	private final String NN = "X";

	// Uses preorder traversal. As the end of tree is represented by null, having
	// only preorder is sufficient
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		System.out.println(sb.toString());
		return sb.toString();
	}

	private void helper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(NN).append(delimitter);
			return;
		}
		sb.append(root.val).append(delimitter);
		helper(root.left, sb);
		helper(root.right, sb);
	}

	// Decoding is very good. Look at the use of queue
	public TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(delimitter)));
		System.out.println(nodes);
		return buildTree(nodes);
	}

	private TreeNode buildTree(Deque<String> nodes) {
		String node = nodes.remove();
		if (node.equals(NN) || node.equals(""))
			return null;
		else {
			TreeNode root = new TreeNode(Integer.parseInt(node));
			root.left = buildTree(nodes);
			root.right = buildTree(nodes);
			return root;
		}
	}
}
