package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
        
		generateParenthesis(n, n, "", res);
		return res;
	}
	
	private void generateParenthesis(int openCount, int closeCount, String curr, List<String> res) {
		if(openCount == 0 && closeCount == 0) {
			res.add(curr);
			return;
		}
		
		if(openCount > 0)
			generateParenthesis(openCount - 1, closeCount, curr + "(", res);
		if(closeCount > openCount)
			generateParenthesis(openCount, closeCount - 1, curr + ")", res);
		
	}

}
