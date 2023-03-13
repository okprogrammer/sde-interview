package heap.impl.problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heaps {

	static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : nums) {
			pq.add(i);
		}
		int data = -1;
		while (k > 0) {
			data = pq.remove();
			k--;
		}
		return data;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int findKthLargest = findKthLargest(nums, 2);
		System.out.println(findKthLargest);
	}
}
