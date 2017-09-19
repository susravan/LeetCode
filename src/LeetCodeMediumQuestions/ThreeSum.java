package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			// Results for same sum should not be duplicated
			if (i == 0 || (nums[i] != nums[i - 1])) {
				int target = -nums[i];	// As the sum of 3 numbers should be zero
				int start = i + 1, end = nums.length - 1;
				while (start < end) {
					if (nums[start] + nums[end] > target)
						end--;
					else if (nums[start] + nums[end] < target)
						start++;
					else {
						res.add(Arrays.asList(nums[start], nums[end], nums[i]));
						// Duplicate numbers should not be added to the result
						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (start < end && nums[end] == nums[end - 1])
							end--;
						start++;
						end--;
					}
				}
			}
		}
		return res;
	}

}
