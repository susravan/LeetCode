package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sravan created on Sep 14, 2017
 *
 */

/*
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 * 
 */


public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();

		generateParenthesis(n, n, "", res);
		return res;
	}

	private void generateParenthesis(int openCount, int closeCount, String curr, List<String> res) {
		if (openCount == 0 && closeCount == 0) {
			res.add(curr);
			return;
		}

		if (openCount > 0)
			generateParenthesis(openCount - 1, closeCount, curr + "(", res);
		if (closeCount > openCount)
			generateParenthesis(openCount, closeCount - 1, curr + ")", res);

	}

}
