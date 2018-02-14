package LeetCodeDifficultQuestions;

import java.util.Arrays;

/**
 * @author sravan created on Sep 10, 2017
 * 
 */

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;

		if (len1 == 0 || len2 == 0)
			return len1 == 0 ? getMedian(nums2) : getMedian(nums1);

		// First argument should have lesser length
//		if (len1 > len2)
//			return findMedianSortedArrays(nums2, nums1);

		int low = 0, high = nums1.length;
		// +1 to make it work both for odd and even lengths
		int combinedMid = (len1 + len2 + 1) / 2;

		while (low <= high) {
			// Approach: Maintain 4 values just before and after partitions in each array
			// and compare them such that each of the left side elements should be less than
			// each of the right elements
			// Can be thought of as binary search on a combined array except that mid index
			// is found using arr1 and second mid index is got from complementing this value
			// with mid of combined array
			int partitionX = low + (high - low) / 2;
			int partitionY = combinedMid - partitionX;

			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = partitionX == len1 ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = partitionY == len2 ? Integer.MAX_VALUE : nums2[partitionY];

			System.out.println(maxLeftX + " | " + minRightX);
			System.out.println(maxLeftY + " | " + minRightY);

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// If sum of lengths is even, average the 4 values, else return the max of left
				// values
				return (len1 + len2) % 2 == 0
						? (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2
						: (double) Math.max(maxLeftX, maxLeftY);
			} else if (maxLeftX > minRightY) {
				high = partitionX - 1;
			} else
				low = partitionX + 1;
		}

		throw new IllegalArgumentException();
	}

	private double getMedian(int[] nums) {
		int len = nums.length;
		if (len == 0 || nums == null)
			return 0;
		return len % 2 == 0 ? (double) (nums[len / 2] + nums[(len - 1) / 2]) / 2 : nums[len / 2];
	}
}
