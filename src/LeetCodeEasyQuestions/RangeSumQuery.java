package LeetCodeEasyQuestions;

public class RangeSumQuery {

	int[] nums;
    int[] cummSum;
    
    public RangeSumQuery(int[] nums) {
        // Storing the cummulative sum of the input array
        this.nums = nums;
        cummSum = new int[nums.length];
        int sum = 0;
        
        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
            cummSum[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0)
            return cummSum[j];
        else
            return cummSum[j] - cummSum[i - 1];
    }

}
