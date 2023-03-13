package tree.impl.bst;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
	private int k;
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public KthLargestElementInStream(int k, int[] nums) {
		this.k = k;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			minHeap.add(nums[i]);
		}
	}

	public int add(int val) {
		while (!minHeap.isEmpty() && minHeap.size() > k) {
			minHeap.poll();
		}
		if (minHeap.isEmpty() || minHeap.size() < k) {
			minHeap.add(val);
		} else if (!minHeap.isEmpty() && minHeap.peek() < val) {
			minHeap.poll();
			minHeap.add(val);
		}
		return minHeap.size() >= k ? minHeap.peek() : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
