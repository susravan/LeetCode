package LeetCodeEasyQuestions;

import java.util.Stack;

/**
 * @author sravan created on Sep 12, 2017
 *
 */

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 *
 */

// Inspired from
public class ValidParenthesis {

	public boolean ValidParenthesis(String s) {

		Stack<Character> st = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(')
				st.push(')');
			else if (c == '[')
				st.push(']');
			else if (c == '{')
				st.push('}');
			else if (st.isEmpty() || st.pop() != c)
				return false;
		}
		return st.isEmpty();
	}

}
