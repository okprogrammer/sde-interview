package heap.impl;

public class MinHeap extends CustomHeap {

	@Override
	protected void shiftUp(int i) {
		int parentIndex = getParentIndex(i);
		if (parentIndex == -1) {
			return;
		}
		if (heap.get(parentIndex) > heap.get(i)) {
			swap(parentIndex, i);
			shiftUp(parentIndex);
		} else {
			return;
		}

	}

	@Override
	protected void shiftDown(int i) {
		int leftChild = leftChild(i);
		int rightChild = rightChild(i);
		int minIndex = i;
		if (leftChild != -1 && heap.get(i) > heap.get(leftChild)) {
			minIndex = leftChild;
		}
		if (rightChild != -1 && heap.get(minIndex) > heap.get(rightChild)) {
			minIndex = rightChild;
		}
		// checking that maxIndex is not same as root index
		// then shifting down
		if (minIndex != i) {
			swap(i, minIndex);
			shiftDown(minIndex);
		} else {
			return;
		}

	}

}
