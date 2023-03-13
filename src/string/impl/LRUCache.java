package string.impl;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Map<Integer, Node> map = new HashMap<>();
	private Node head = new Node(0, 0);
	private Node tail = new Node(0, 0);
	private int capacity;

	public LRUCache(int capacity) {
		this.head.next = this.tail;
		this.tail.prev = this.head;
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			add(node);
			return node.value;
		}
		return -1;
	}

	private void add(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
		node.prev = head;
	}

	private void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (map.size() == capacity) {
			remove(tail.prev);
		}
		add(new Node(key, value));
	}

	class Node {
		private Node next, prev;
		private int key;
		private int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
