package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Feb 17, 2018
 */

/**
 * Count sort is one of the non-comparision based sorting which takes on an
 * average O(N) time You need to have the range of possible numbers to use this
 */

// Inspired from
public class CountSort {
	// Assuming we have numbers from 0 to 9
	public int[] countSort(int[] nums) {
		int[] sortedArr = new int[nums.length];
		int[] countArr = new int[10];

		// Store counts of all numbers in countArr
		for (int i = 0; i < nums.length; i++) {
			countArr[nums[i]]++;
		}
		// Cummulate countArr - represents the last index of that number in the sorted
		// array
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		// Use countArr to formulate new sorted array
		for (int i = 0; i < nums.length; i++) {
			int index = countArr[nums[i]]-1; // Possible last index where nums[i] can present in sorted array
			sortedArr[index] = nums[i];
			countArr[nums[i]]--;
		}
		return sortedArr;
	}
}
