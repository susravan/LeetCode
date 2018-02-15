package LeetCodeDifficultQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sravan
 * Created on Feb 14, 2018
 */

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 **/

// Inspired from https://leetcode.com/problems/merge-k-sorted-lists/solution/
public class MergeKSortedLists {
	public ListNode mergeKSortedLists(ListNode[] lists) {
		// Using a priority Queue
		ListNode res = new ListNode(0);
		ListNode dummy = res;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		// Add all start nodes
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}

		// Until pq is empty take one out from it and add to res
		while (pq.size() != 0) {
			ListNode nextNode = pq.poll();
			res.next = nextNode;
			res = res.next;
			if (nextNode.next != null) {
				nextNode = nextNode.next;
				pq.add(nextNode);
			}
		}
		return dummy.next;
	}

}
