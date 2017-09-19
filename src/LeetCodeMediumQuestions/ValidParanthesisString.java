package LeetCodeMediumQuestions;

import java.util.Stack;

public class ValidParanthesisString {

	public boolean checkValidParanthesisString(String str) {
		if(str.length() == 0)
			return true;
		
		Stack<Character> st = new Stack<>();
		int slack = 0;
		
		for(int i=0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == ')') {
				if(!st.isEmpty()) {
					char popChar = st.pop();
				}
				else {
					slack--;
				}
			}
			else {
				if(c == '*')
					slack++;
				else
					st.push(c);
			}
				
		}
		return (st.isEmpty() || st.size() == slack) && slack >= 0;
	}

}
