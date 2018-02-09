package LeetCodeEasyQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sravan
 * Created on Feb 8, 2018
 */

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 */

// Inspired from
public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		// Put a region of k elements in the set then check if the new element is
		// present in the set. If present return true else false. Note that the element
		// should be removed first and then checked for existence
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i]))
				return true;
		}
		return false;
	}
}
