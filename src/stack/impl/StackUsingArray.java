package stack.impl;

class StackUnderFlowException extends Exception {

	public StackUnderFlowException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

public class StackUsingArray {

	private int top = -1;
	private int[] arr;

	public int getTop() {
		return arr[top];
	}

	public StackUsingArray() {
		arr = new int[10];
	}

	public StackUsingArray(int size) {
		arr = new int[size];
	}

	int pop() {
		if (top == -1) {
			return top;
		}
		int data = arr[top];
		arr[top] = -1;
		top--;
		return data;
	}

	void add(int data) throws StackUnderFlowException {
		if (top == getSize() - 1) {
			throw new StackUnderFlowException("Stack is Full.");
		}
		++top;
		arr[top] = data;
	}

	int getSize() {
		return arr.length;
	}

	boolean isFull() {
		return top == getSize() - 1;
	}

	boolean isEmpty() {
		return top == -1;
	}
}
