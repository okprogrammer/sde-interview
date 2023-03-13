package heap.impl;

import java.util.ArrayList;

public abstract class CustomHeap {

	protected ArrayList<Integer> heap;

	public CustomHeap() {
		heap = new ArrayList<>();
	}

	protected abstract void shiftUp(int i);

	protected abstract void shiftDown(int i);

	public void insert(int data) {
		heap.add(data);
		shiftUp(heap.size() - 1);
	}

	protected int getParentIndex(int i) {
		int index = (i / 2);
		return index >= 0 ? index : -1;
	}

	protected int leftChild(int i) {
		int leftChild = (2 * i) + 1;
		if (leftChild > size() - 1) {
			return -1;
		}
		return leftChild;
	}

	protected int rightChild(int i) {
		int rightChild = (2 * i) + 2;
		if (rightChild > size() - 1) {
			return -1;
		}
		return rightChild;
	}

	protected void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	protected void display() {
		heap.stream().forEach(System.out::println);
	}

	protected void delete(int num) throws Exception {
		int n = size();
		if (n == 0) {
			throw new Exception("Heap is Emtpy!");
		}
		int i = -1;
		for (i = 0; i < n; i++) {
			if (num == heap.get(i)) {
				break;
			}
		}
		if (i == n) {
			throw new Exception("Element is not present!");
		} else {
//			heap.set(i, heap.get(n - 1));
//			heap.set(n - 1, num);
			swap(i, n - 1);
			heap.remove(n - 1);
			shiftDown(i);
			System.out.format("%s is deleted from the heap ", num);
			System.out.println();
		}
	}

	int size() {
		return heap.size();
	}
}
