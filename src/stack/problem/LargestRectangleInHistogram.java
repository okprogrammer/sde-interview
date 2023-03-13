package stack.problem;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] leftArray = new int[n];
		int[] rightArray = new int[n];
		Stack<Integer> st = new Stack<>();
		makeNextGreaterElement(leftArray, heights, st, n);
		st.removeAllElements();
		makeNextSmallerElement(rightArray, heights, st, n);
		int maxArea = -1;
		for (int i = 0; i < n; i++) {
			int area = (rightArray[i] - leftArray[i] + 1) * heights[i];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	private static void makeNextSmallerElement(int[] rightArray, int[] heights, Stack<Integer> st, int n) {
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				rightArray[i] = n - 1;
			} else {
				rightArray[i] = st.peek() - 1;
			}
			st.push(i);
		}
	}

	private static void makeNextGreaterElement(int[] leftArray, int[] heights, Stack<Integer> st, int n) {
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				leftArray[i] = 0;
			} else {
				leftArray[i] = st.peek() + 1;
			}
			st.push(i);
		}
	}

	static int largestRectangleAreaMethod2(int[] heights) {
		int n = heights.length;
		Stack<Integer> st = new Stack<>();
		int maxA = -1;
		for (int i = 0; i <= n; i++) {
			while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
				int h = heights[st.pop()];
				int width;
				if (st.isEmpty()) {
					width = i;
				} else {
					width = i - st.peek() - 1;
				}
				maxA = Math.max(maxA, width * h);
			}
			st.push(i);
		}
		return maxA;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1 };
		int ans = largestRectangleAreaMethod2(arr);
		System.out.println(ans);
	}

}
