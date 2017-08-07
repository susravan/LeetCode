package LeetCodeEasyQuestions;

import java.util.Arrays;

/**
 * @author sravan
 * created on Aug 6, 2017
 *
 */

/*  You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 *
 */


public class NextGreaterElement1 {

	public int[] nextGreaterElement1(int[] findNums, int[] nums) {
		int[] result = new int[findNums.length];
        Arrays.fill(result, -1);
        
        for(int k=0; k<findNums.length; k++) {
            for(int i=0; i<nums.length; i++) {
                if(findNums[k] == nums[i]) {
                    int j = i + 1;
                    while(j < nums.length) {
                        if(nums[j] > nums[i]) {
                            result[k] = nums[j];
                            break;
                        }
                        j++;
                    }
                }
            }
        }
        return result;
	}

}
