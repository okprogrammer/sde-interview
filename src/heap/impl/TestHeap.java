package heap.impl;

public class TestHeap {
	public static void main(String[] args) throws Exception {
		CustomHeap heap = new MinHeap();
		for (int i = 1; i <= 10; i++) {
			heap.insert((int) (i * Math.random() * 10));
		}
		heap.display();
		System.out.println("==================================");
		heap.delete(heap.heap.get(3));
		heap.display();
//		CustomHeap heap1 = new MinHeap();
//		for (int i = 1; i <= 10; i++) {
//			heap1.insert((int) (i * Math.random() * 10));
//		}
//		System.out.println("=================================");
//		heap1.display();
	}
}
