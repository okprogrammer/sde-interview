package linkedlist1;

public class LinkedListNode<T> {
	private T data;
	LinkedListNode<T> next;

	public LinkedListNode() {

	}

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}
