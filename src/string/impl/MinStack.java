package string.impl;

import java.util.Stack;

class Pair {
	int x;
	int min;

	public Pair(int x, int min) {
		this.x = x;
		this.min = min;
	}

}

public class MinStack {
	private Stack<Pair> st;

	public MinStack() {
		this.st = new Stack<>();
	}

	public void push(int val) {
		if (st.isEmpty()) {
			st.push(new Pair(val, val));
		} else {
			st.push(new Pair(val, Math.min(val, st.peek().min)));
		}
	}

	public void pop() {
		st.pop();
	}

	public int top() {
		return this.st.peek().x;
	}

	public int getMin() {
		return this.st.peek().min;
	}
}
