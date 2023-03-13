package queue.impl;

import java.util.Stack;

public class QueueUsingTwoStack {

	Stack<Integer> firstStack = new Stack<>();
	Stack<Integer> secondStack = new Stack<>();

	void push(int data) {
		while (!firstStack.isEmpty()) {
			secondStack.push(firstStack.pop());
		}
		System.out.println("Added element: " + data);
		secondStack.push(data);
		while (!secondStack.isEmpty()) {
			firstStack.push(secondStack.pop());
		}
	}

	int pop() {
		return firstStack.pop();
	}

	int peek() {
		return firstStack.peek();
	}
}
