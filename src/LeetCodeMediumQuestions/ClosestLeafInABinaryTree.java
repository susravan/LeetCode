package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Sravan
 * Created on Mar 6, 2018
 */

/**
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The nearest leaf node is the root node itself.
Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
Note:
root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.
 */

// Inspired from 
public class ClosestLeafInABinaryTree {
	// Approach: Construct an undirected graph from the given binary tree and search
	// for the required node in the graph
	// Leaf node translates to a node that doesn't have any children (though the
	// value list contains the parent)
	public int closestLeaf(TreeNode root, int k) {
		Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
		createGraph(graph, root, null); // Create undirected graph

		// BFS on created graph
		Queue<TreeNode> q = new LinkedList<>();
		Set<TreeNode> seen = new HashSet<>();

		// Instead of starting from root and finding node k, start from node k itself by
		// finding it first
		for (TreeNode curr : graph.keySet()) {
			if (curr != null && curr.val == k) {
				q.offer(curr);
				seen.add(curr);
			}
		}

		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			if (curr != null) {
				if (graph.get(curr).size() <= 1)
					return curr.val;
				for (TreeNode child : graph.get(curr)) {
					if (!seen.contains(child)) {
						seen.add(child);
						q.offer(child);
					}
				}
			}
		}

		return 0;
	}

	// Creates undirected graph from the input tree
	private void createGraph(Map<TreeNode, List<TreeNode>> graph, TreeNode root, TreeNode parent) {
		if (root == null)
			return;
		if (!graph.containsKey(root))
			graph.put(root, new ArrayList<>());
		if (!graph.containsKey(parent))
			graph.put(parent, new ArrayList<>());
		graph.get(root).add(parent);
		graph.get(parent).add(root);
		createGraph(graph, root.left, root);
		createGraph(graph, root.right, root);
	}
}
