package queue.impl;

public class QueueTesting {

	public static void main(String[] args) {
		QueueUsingTwoStack st = new QueueUsingTwoStack();
		for (int i = 1; i < 11; i++) {
			st.push(i);
		}
		System.out.println(st.pop());
	}

}
