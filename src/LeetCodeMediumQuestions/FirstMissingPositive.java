package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Given an unsorted integer array, find the first missing
 *         positive integer.
 * 
 *         For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 *         Your algorithm should run in O(n) time and uses constant space.
 *
 * 
 */

// Inspired from https://leetcode.com/problems/first-missing-positive/discuss/17073
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        // k has the first non-positive number';'s index in the seggregated array
        int maxPositiveIndex = seggregateArray(nums);
        // System.out.println("k = " + k + Arrays.toString(nums));
        
        for(int i=0; i < maxPositiveIndex; i++) {
            int absValue = Math.abs(nums[i]);
            if(absValue <= maxPositiveIndex) {
                nums[absValue-1] = nums[absValue-1] > 0 ? -nums[absValue-1] : nums[absValue-1];
            }
        }
        // System.out.println(Arrays.toString(nums));
        int i=0;
        for(i=0; i < maxPositiveIndex; i++) {
            if(nums[i] > 0)
                return i+1;
        }
        return i+1;
    }
    
    private int seggregateArray(int[] arr) {
        int lo=0, high = arr.length-1;
        while(lo <= high) {
            System.out.println(lo + ", " + high);
            while(lo < arr.length && arr[lo] > 0)
                lo++;
            System.out.println(high + ", " + arr[high]);
            while(high >= 0 && arr[high] <= 0)
                high--;
            if(lo < high) {
                int temp = arr[lo];
                arr[lo] = arr[high];
                arr[high] = temp;
                lo++;
                high--;
            }
        }
        return lo;
    }
}
