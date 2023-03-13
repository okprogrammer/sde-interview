package heap.impl;

public class MaxHeap extends CustomHeap {

	@Override
	protected void shiftUp(int i) {
		int parentIndex = getParentIndex(i);
		if (parentIndex == -1) {
			return;
		}
		if (heap.get(parentIndex) < heap.get(i)) {
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
		int maxIndex = i;
		if (leftChild != -1 && heap.get(i) < heap.get(leftChild)) {
			maxIndex = leftChild;
		}
		if (rightChild != -1 && heap.get(maxIndex) < heap.get(rightChild)) {
			maxIndex = rightChild;
		}
		// checking that maxIndex is not same as root index
		// then shifting down
		if (maxIndex != i) {
			swap(i, maxIndex);
			shiftDown(maxIndex);
		} else {
			return;
		}
	}

}
