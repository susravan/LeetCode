package LeetCodeEasyQuestions;

import java.util.Stack;

/**
 * @author Sravan
 * Created on Jan 29, 2018
 */

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 *  MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> Returns -3.
	minStack.pop();
	minStack.top();      --> Returns 0.
	minStack.getMin();   --> Returns -2.
 */

public class MinStack {
	int min;
	Stack<Integer> st;

	/** initialize your data structure here. */
	public MinStack() {
		min = Integer.MAX_VALUE;
		st = new Stack<>();
	}

	public void push(int x) {
		if (x <= min) {
			st.push(min);
			min = x;
		}
		st.push(x);
	}

	public void pop() {
		if (st.pop() == min)
			min = st.pop();
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		return min;
	}
}
