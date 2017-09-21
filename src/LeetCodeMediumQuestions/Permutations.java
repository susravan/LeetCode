package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public List<List<Integer>> Permutations(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
        List<Integer> numsList = Arrays.asList(nums);
        List<Integer> tempList = new ArrayList<>();
        
        permuteHelper(numsList, tempList, res);
        return res;
	}

	private void permuteHelper(List<Integer> numList, List<Integer> perm, List<List<Integer>> res) {
        if(numList.size() == 0) {
            res.add(perm);
            return;
        }
        
        for(int i=0; i < numList.size(); i++) {
            int currNum = numList.remove(i);
            perm.add(currNum);
            permuteHelper(numList, perm, res);
            perm.remove(currNum);
            numList.add(i, currNum);
        }
        return;
    }
}
