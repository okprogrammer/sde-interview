package collection.impl;

import java.util.ArrayDeque;

public class ArrayDequeueClass {
	public static void main(String[] args) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i < 10; i++) {
			dq.offerFirst(i);
		}
		dq.forEach((x) -> System.out.println(x));
	}
}
