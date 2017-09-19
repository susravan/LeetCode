package LeetCodeMediumQuestions;

import java.util.PriorityQueue;

/**
 * @author sravan created on Aug 11, 2017
 *
 */

/*
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15] ], k = 8,
 * 
 * return 13. Note: You may assume k is always valid, 1 ? k ? n2.
 *
 */

// Inspired from
// https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code

public class KthSmallestElementInSortedMatrix {

	public int getKthSmallestElementInSortedMatrix(int[][] matrix, int k) {
		// Approach - Use min heap to get the smallest element
		// and then add next smallest element to it (next row, same column)
		int len = matrix.length, wid = matrix[0].length;
		
		// Put all elements of first row into the queue
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int col = 0; col < wid; col++) {
			pq.offer(new Node(0, col, matrix[0][col]));
		}

		// Only from 1 to k - 1. Last poll will be returned as a result
		for (int i = 1; i < k; i++) {
			Node temp = pq.poll();
			if (temp.row == len - 1)
				continue;
			pq.offer(new Node(temp.row + 1, temp.col, matrix[temp.row + 1][temp.col]));
		}
		return pq.poll().val;
	}

	private class Node implements Comparable<Node> {
		int row;
		int col;
		int val;

		public Node(int x, int y, int val) {
			this.row = x;
			this.col = y;
			this.val = val;
		}

		// Overriding the compareTo method for custom comparision
		public int compareTo(Node n) {
			return this.val - n.val;
		}

	}
}
