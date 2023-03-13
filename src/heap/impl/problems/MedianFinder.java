package heap.impl.problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public MedianFinder() {

	}

	public void addNum(int num) {
		if (maxHeap.isEmpty() && minHeap.isEmpty()) {
			maxHeap.add(num);
		} else {
			if (maxHeap.peek() < num) {
				minHeap.add(num);
			} else {
				maxHeap.add(num);
			}
		}
		int n = maxHeap.size();
		int m = minHeap.size();
		if (Math.abs(m - n) == 2) {
			if (n > m) {
				minHeap.add(maxHeap.poll());
			} else {
				maxHeap.add(minHeap.poll());
			}
		}
	}

	public double findMedian() {
		int n = maxHeap.size();
		int m = minHeap.size();
		if ((n + m) % 2 == 0) {
			int first = n != 0 ? maxHeap.peek() : 0;
			int second = m != 0 ? minHeap.peek() : 0;
			return ((double) first + (double) second) / 2.0;
		} else if (m > n) {
			return minHeap.peek();
		} else {
			return maxHeap.peek();
		}
	}
}
