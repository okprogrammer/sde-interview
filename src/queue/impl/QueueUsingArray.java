package queue.impl;

class QueueUnderFlowException extends Exception {

	public QueueUnderFlowException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6918967372728460893L;

}

class QueueOverFlowException extends Exception {

	public QueueOverFlowException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6918967372728460893L;

}

public class QueueUsingArray {
	private int start = -1;
	private int end = -1;
	private int[] queue;
	private int count = 0;

	public QueueUsingArray() {
		this.queue = new int[10];
	}

	public QueueUsingArray(int size) {
		this.queue = new int[size];
	}

	void add(int data) throws QueueOverFlowException {
		if (isFull()) {
			throw new QueueOverFlowException("Queue is Full.");
		}
		if (start == -1) {
			start++;
		}
		end = (end + 1) % getSize();
		queue[end] = data;
		System.out.println("Enque data is: " + queue[end]);
		count++;
	}

	boolean isFull() {
		return count == getSize();
	}

	private int getSize() {
		return queue.length;
	}

	int pop() throws QueueUnderFlowException {
		if (isEmpty()) {
			throw new QueueUnderFlowException("Queue is Empty.");
		}
		int data = queue[start];
		start = (start + 1) % getSize();
		count--;
		if (count == 0) {
			start = end = -1;
		}
		return data;
	}

	boolean isEmpty() {
		return count == 0;
	}
}
