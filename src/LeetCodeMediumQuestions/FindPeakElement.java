package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 27, 2018
 */

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * Note: Your solution should be in logarithmic complexity.
 *
 * 
 * 
 */

// Inspired from https://leetcode.com/problems/find-peak-element/solution/
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		// Approach: Sort of greedy approach. As it is given that any peak is valid, at
		// each point, we look for trend at mid and make a decision based on that info
		// and continue until lo >= high. From this question, we can infer that binary
		// search can be applied for unsorted array also
		int lo = 0, high = nums.length - 1;

		while (lo < high) {
			int mid = lo + (high - lo) / 2;

			if (nums[mid] < nums[mid + 1])
				lo = mid + 1;
			else
				high = mid;
		}
		return lo;
	}
}
