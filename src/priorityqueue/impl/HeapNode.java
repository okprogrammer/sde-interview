package priorityqueue.impl;

public class HeapNode<T> {
	private T data;
	private int priority;

	public HeapNode() {
	}

	public HeapNode(T data, int priority) {
		this.data = data;
		this.priority = priority;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
