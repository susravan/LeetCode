package LeetCodeDifficultQuestions;

import java.util.Stack;

/**
 * @author Sravan
 * Given a string containing just the characters '(' and ')',
 *         find the length of the longest valid (well-formed) parentheses
 *         substring.
 * 
 *         For "(()", the longest valid parentheses substring is "()", which has
 *         length = 2.
 * 
 *         Another example is ")()())", where the longest valid parentheses
 *         substring is "()()", which has length = 4.
 *
 */

// Inspired from
// https://leetcode.com/problems/longest-valid-parentheses/solution/#approach-2-using-dynamic-programming-accepted
public class LongestValidParanthesis {
	public int longestValidParanStack(String str) {
		// Approach - Using stack
		// '(' - push index to stack
		// ')' - pop topmost, update maxLen with i-st.peek(). If st.isEmpty(), we push
		// current index to stack
		int maxLen = 0, index = 0;
		Stack<Integer> st = new Stack<>();
		st.push(-1);

		while (index < str.length()) {
			if (str.charAt(index) == '(') {
				st.push(index);
            }
			else {
                st.pop();
				// if stack empty push ) index also, else update maxLen
                if(st.isEmpty())
					st.push(index); // This pushed element is required as we will pop if next char is ')'
				else
					maxLen = Math.max(maxLen, index - st.peek());
			}
            index++;
		}
		return maxLen;
	}
	
	public int longestValidParanWOExtraSpace(String str) {
		// Approach - Maintain left and right bracket counters
		// Two traversals:
		// L-R -> at any point if right>left, update maxLen and reset both
		// R-L -> at any point if left>right, update maxLen and reset both
		int maxLen = 0, left = 0, right = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				left++;
			else
				right++;
			if (left == right)
				maxLen = Math.max(maxLen, left * 2);
			else if (left < right)
				left = right = 0;
		}

		left = right = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '(')
				left++;
			else
				right++;
			if (left == right)
				maxLen = Math.max(maxLen, left * 2);
			else if (right < left)
				left = right = 0;
		}
		return maxLen;
	}
}
