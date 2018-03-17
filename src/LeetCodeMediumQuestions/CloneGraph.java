package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Sravan
 * Created on Mar 17, 2018
 */

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 */


public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		map.put(node.label, newNode);
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.offer(node);

		while (!q.isEmpty()) {
			UndirectedGraphNode currNode = q.poll();
			for (UndirectedGraphNode child : currNode.neighbors) {
				if (!map.containsKey(child.label)) {
					q.add(child);
					UndirectedGraphNode childNode = new UndirectedGraphNode(child.label);
					map.put(child.label, childNode);
				}
				map.get(currNode.label).neighbors.add(map.get(child.label));
			}
		}
		return newNode;
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}