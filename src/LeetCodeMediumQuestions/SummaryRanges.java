package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sravan
 * created on Aug 7, 2017
 *
 */

/* Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */

// Inspired from https://leetcode.com/problems/summary-ranges/discuss/
public class SummaryRanges {

	public List<String> getSummaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
        
        for(int i=0; i < nums.length; i++) {
            int currNum = nums[i];
            while(i+1 < nums.length && (nums[i+1]-nums[i])==1) {
                i++;
            }
            if(currNum != nums[i])
                res.add(currNum + "->" + nums[i]);
            else
                res.add(currNum + "");
    	}
        return res;
	}

}
