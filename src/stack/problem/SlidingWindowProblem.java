package stack.problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowProblem {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] arr = new int[n - k + 1];
		int maxElement = Integer.MIN_VALUE;
		for (int i = 0; i <= n - k; i++) {
			for (int j = 0; j < k; j++) {
				maxElement = Math.max(maxElement, nums[i + j]);
			}
			arr[i] = maxElement;
			maxElement = Integer.MIN_VALUE;
		}
		return arr;
	}

	public static int[] maxSlidingWindowBetter(int[] nums, int k) {
		int n = nums.length;
		int[] arr = new int[n - k + 1];
		Deque<Integer> dq = new ArrayDeque<>();
		int ri = 0;
		for (int i = 0; i < n; i++) {
			// remove number out range k
			if (!dq.isEmpty() && dq.peek() == i - k) {
				dq.poll();
			}
			// remove the smaller number in the range of k
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}
			dq.offer(i);
			if (i >= k - 1) {
				arr[ri++] = nums[dq.peek()];
			}

		}
		return arr;
	}

	public static void main(String[] args) {
		int[] input = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] ans = maxSlidingWindowBetter(input, 3);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
