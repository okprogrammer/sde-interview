package priorityqueue.impl;

import java.util.ArrayList;

public abstract class CustomPriorityQueue<T> {

	protected ArrayList<HeapNode<T>> queue;

	public CustomPriorityQueue() {
		this.queue = new ArrayList<>();
	}

	public CustomPriorityQueue(int size) {
		this.queue = new ArrayList<>(size);
	}

	protected abstract void shiftUp(int i);

	protected abstract void shiftDown(int i);

	void insert(T data, int priority) {
		queue.add(new HeapNode<>(data, priority));
		shiftUp(size() - 1);
	}

	void delete(T data) throws Exception {
		int i = -1;
		if (size() == 0) {
			throw new Exception("Queue is Empty!");
		}
		for (i = 0; i < queue.size(); i++) {
			if (data == queue.get(i).getData()) {
				break;
			}
		}
		swap(i, size() - 1);
		shiftDown(i);
	}

	void swap(int i, int j) {
		HeapNode<T> temp = queue.get(i);
		queue.set(i, queue.get(j));
		queue.set(j, temp);
	}

	private int size() {
		return queue.size();
	}

	int getParentIndex(int i) {
		return (i / 2);
	}

	int leftChildIndex(int i) {
		int leftChild = 2 * i + 1;
		if (leftChild > size() - 1) {
			return -1;
		}
		return leftChild;
	}

	int rightChildIndex(int i) {
		int rightChild = 2 * i + 2;
		if (rightChild > size() - 1) {
			return -1;
		}
		return rightChild;
	}

	void display() {
		queue.stream().forEach(e -> System.out.println(e.getData() + " " + e.getPriority()));
	}

}
