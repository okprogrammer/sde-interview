package stack.impl;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSinleQueue {
	Queue<Integer> queue = new LinkedList<>();

	void push(int data) {
		queue.add(data);
		for (int i = 0; i < queue.size(); i++) {
			queue.add(queue.remove());
		}
	}

	int pop() {
		return queue.poll();
	}

}
