package priorityqueue.impl;

public class MinPriorityQueue<T> extends CustomPriorityQueue<T> {

	@Override
	protected void shiftUp(int i) {
		int parentIndex = getParentIndex(i);
		if (parentIndex != -1 && queue.get(i).getPriority() < queue.get(parentIndex).getPriority()) {
			swap(i, parentIndex);
			shiftUp(parentIndex);
		} else {
			return;
		}

	}

	@Override
	protected void shiftDown(int i) {
		int leftChild = leftChildIndex(i);
		int rightChild = rightChildIndex(i);
		int minIndex = i;
		if (leftChild != -1 && queue.get(i).getPriority() > queue.get(leftChild).getPriority()) {
			minIndex = leftChild;
		}
		if (rightChild != -1 && queue.get(minIndex).getPriority() > queue.get(rightChild).getPriority()) {
			minIndex = rightChild;
		}
		if (minIndex != i) {
			swap(minIndex, i);
			shiftDown(minIndex);
		} else {
			return;
		}

	}

}
