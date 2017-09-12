package LeetCodeEasyQuestions;

public class LongestIncresingContSubSequence {

	public int getLongestIncresingContSubSequence(int[] nums) {
		if(nums.length == 0)
            return 0;
        if(nums.length < 2)
            return 1;
        int max_so_far = 0;
        int max_len = 0;
        int[] memo = new int[nums.length];
        memo[0] = 1;
        
        for(int i=1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                memo[i] = memo[i-1] + 1;
            }
            else
                memo[i] = 1;
            max_so_far = Math.max(max_so_far, memo[i]);
            max_len = Math.max(max_len, max_so_far);
        }
        return max_len;
	}

}
