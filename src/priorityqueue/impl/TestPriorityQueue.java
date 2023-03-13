package priorityqueue.impl;

public class TestPriorityQueue {

	public static void main(String[] args) {
		CustomPriorityQueue<Integer> queue = new MinPriorityQueue<>();
		for (int i = 1; i < 11; i++) {
			queue.insert((int) ((Math.random() + 1) * 10), i);
		}
		queue.display();
		System.out.println("===========Max Priority Queue========================");
		CustomPriorityQueue<Integer> maxQueue = new MaxPriorityQueue<>();
		for (int i = 1; i < 11; i++) {
			maxQueue.insert((int) ((Math.random() + 1) * 10), i);
		}
		maxQueue.display();
	}
}
