package LeetCodeDifficultQuestions;

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

	public double getMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		if(len1 == 0 || len2 == 0)
			return len1 == 0 ? getMedian(nums2) : getMedian(nums1);
//		if(len1 == 1)
		return 0;
	}
	
	private double getMedianOfTwoSortedArraysHelper(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2) {
		
		return 0;
	}
	
	private double getMedian(int[] nums) {
		int len = nums.length;
		if(len == 0)
			return 0;
		
		if(len % 2 == 0) {
			return (nums[len/2] + nums[(len/2) -1])/2;
		}
		else
			return nums[len/2];
	}
}
