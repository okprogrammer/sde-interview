package stack.problem;

import java.util.Stack;

public class SortUsingImpl {

	static void sortStackUsingRec(Stack<Integer> st, int x) {
		if (st.isEmpty() || x > st.peek()) {
			st.push(x);
			return;
		}
		int temp = st.pop();
		sortStackUsingRec(st, x);
		st.push(temp);
	}

	static void sortStackUsingRec(Stack<Integer> st) {
		// if the stack is not empty
		if (!st.isEmpty()) {
			int x = st.pop();
			// sort remaining
			sortStackUsingRec(st);
			// put top element back in stack
			sortStackUsingRec(st, x);
		}
	}

	static Stack<Integer> sortStack(Stack<Integer> st) {
		Stack<Integer> output = new Stack<>();
		output.push(st.pop());
		while (!st.isEmpty()) {
			int top = st.pop();
			while (!output.isEmpty() && output.peek() > top) {
				st.push(output.pop());
			}
			output.push(top);
		}
		return output;
	}

	public static void main(String[] args) {
		Stack<Integer> input = new Stack<>();
		Stack<Integer> input1 = new Stack<>();
		for (int i = 0; i < 10; i++) {
			input.push((int) ((Math.random() + 1) * 10));
			input1.push((int) ((Math.random() + 1) * 10));

		}
		Stack<Integer> ans = sortStack(input);
		ans.forEach(e -> System.out.println(e));
		System.out.println("===============================");
		sortStackUsingRec(input1);
		input1.forEach(System.out::println);
	}

}
