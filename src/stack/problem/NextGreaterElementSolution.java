package stack.problem;

import java.util.Stack;

public class NextGreaterElementSolution {

	static int[] nextGreaterElementsWithoutCircularArr(int[] nums) {
		Stack<Integer> st = new Stack<>();
		int n = nums.length;
		int[] arr = new int[n];
		arr[n - 1] = -1;
		st.push(nums[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			int key = nums[i];
			while (!st.isEmpty() && key > st.peek()) {
				st.pop();
			}
			if (st.isEmpty()) {
				arr[i] = -1;
			} else {
				arr[i] = st.peek();
			}
			st.push(key);
		}
		return arr;
	}

	static int[] nextGreaterElementsCircular(int[] nums) {
		Stack<Integer> st = new Stack<>();
		int n = nums.length;
		int[] arr = new int[n];
		arr[n - 1] = -1;
		st.push(nums[n - 1]);
		for (int i = 2 * n - 1; i >= 0; i--) {
			int index = i % n;
			int key = nums[index];
			while (!st.isEmpty() && key >= st.peek()) {
				st.pop();
			}
			if (st.isEmpty()) {
				arr[index] = -1;
			} else {
				arr[index] = st.peek();
			}
			st.push(key);
		}
		return arr;
	}

	public static void main(String[] args) {
		int A[] = { 5, 7, 1, 2, 6, 0 };
		int[] ans = nextGreaterElementsWithoutCircularArr(A);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
