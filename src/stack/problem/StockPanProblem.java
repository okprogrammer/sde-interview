package stack.problem;

import java.util.Stack;

public class StockPanProblem {
	// creating array of stack
	Stack<int[]> stack;

	public StockPanProblem() {
		this.stack = new Stack<>();
	}

	public int next(int price) {
		int count = 1;
		// remove the element from until peek element is less than or equal to price
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			count += stack.pop()[1];
		}
		// pushing 2 size array in stack
		// 0 index - price
		// 1 index - count
		stack.push(new int[] { price, count });
		return count;
	}
}
