package LeetCodeDifficultQuestions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sravan
 * Created on Apr 3, 2018
 */

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 */

// Inspired from
// https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		int[] res = new int[len - k + 1];
		Deque<Integer> q = new LinkedList<>();
		q.add(0);

		for (int i = 1; i < nums.length; i++) {
			while (!q.isEmpty() && nums[i] > nums[q.peekLast()])
				q.pollLast();
			q.add(i);

			if (q.peekFirst() == i - k)
				q.poll();

			if (i >= k - 1)
				res[i - k + 1] = nums[q.peek()];
		}
		return res;
	}
}
