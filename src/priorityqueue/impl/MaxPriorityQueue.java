package priorityqueue.impl;

public class MaxPriorityQueue<T> extends CustomPriorityQueue<T> {

	@Override
	protected void shiftUp(int i) {
		int parentIndex = getParentIndex(i);
		if (parentIndex != -1 && queue.get(i).getPriority() > queue.get(parentIndex).getPriority()) {
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
		int maxIndex = i;
		if (leftChild != -1 && queue.get(i).getPriority() < queue.get(leftChild).getPriority()) {
			maxIndex = leftChild;
		}
		if (rightChild != -1 && queue.get(maxIndex).getPriority() < queue.get(rightChild).getPriority()) {
			maxIndex = rightChild;
		}
		if (maxIndex != i) {
			swap(maxIndex, i);
			shiftDown(maxIndex);
		} else {
			return;
		}
	}

}
