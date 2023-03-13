package queue.impl;

public class QueueImpl {
	public static void main(String[] args) {
		QueueUsingArray q = new QueueUsingArray();
		for (int i = 1; i < 15; i++) {
			try {
				q.add(i);
			} catch (QueueOverFlowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			for (int i = 0; i < 12; i++) {
				System.out.println(q.pop());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
