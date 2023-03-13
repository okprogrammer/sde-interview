package stack.impl;

import java.util.Stack;

public class StackProblem {

	static boolean balancedParanetheisis(String input) {
		Stack<Character> st = new Stack<>();
		int n = input.length();
		for (int i = 0; i < n; i++) {
			char it = input.charAt(i);
			if (it == '(' || it == '{' || it == '[') {
				st.push(it);
			} else {
				if (st.isEmpty()) {
					return false;
				}
				char c = st.pop();
				if (!(c == '(' && it == ')' || c == '{' && it == '}' || c == '[' && it == ']')) {
					return false;
				}
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
		String input = "()[{}()]";
		System.out.println(balancedParanetheisis(input));
	}

}
