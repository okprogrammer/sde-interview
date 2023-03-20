package hash.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMap<K, V> {

	private int noOfEntries;
	private int bucketSize;

	private LinkedList<Node<K, V>>[] buckets;

	public CustomHashMap(int noOfEntries, int bucketSize, LinkedList<Node<K, V>>[] buckets) {
		super();
		this.noOfEntries = noOfEntries;
		this.bucketSize = bucketSize;
		this.buckets = buckets;
	}

	public CustomHashMap() {
		this.bucketSize = 10;
		this.noOfEntries = 0;
		System.out.println("Constructor initialized");
		initBuckets(buckets, bucketSize);
	}

	private void initBuckets(LinkedList<Node<K, V>>[] buckets, int bucketSize) {
		System.out.println("Bucket intialized.");
		this.buckets = new LinkedList[bucketSize];
		for (int i = 0; i < bucketSize; i++) {
			this.buckets[i] = new LinkedList<>();
		}
	}

	public void put(K key, V value) throws Exception {
		int hc = hashFun(key);
		int index = getIndex(key, hc);
		if (index != -1) {
			Node<K, V> node = buckets[hc].get(index);
			node.setValue(value);
		} else if (index == -1) {
			Node<K, V> node = new Node<>(key, value);
			buckets[hc].add(node);
			noOfEntries++;
		}
		if ((noOfEntries * (1.0) / bucketSize) > .7) {
			extendBucketSize();
		}
	}

	private int getIndex(K key, int hc) {
		int index = 0;
		if (noOfEntries == 0) {
			return -1;
		}
		for (Node<K, V> e : buckets[hc]) {
			if (e != null && e.getKey().equals(key)) {
				return index;
			} else {
				index++;
			}
		}
		return -1;
	}

	private int hashFun(K key) {
		int hashCode = key.hashCode();
		return Math.abs(hashCode) % size();
	}

	private int size() {
		return this.buckets.length;
	}

	private void extendBucketSize() throws Exception {
		bucketSize = 2 * bucketSize;
		LinkedList<Node<K, V>>[] temp = buckets;
		this.buckets = new LinkedList[bucketSize];
		for (int i = 0; i < bucketSize; i++) {
			buckets[i] = new LinkedList<>();
		}
		System.out.println("Bucket size increased " + temp.length + " to" + bucketSize);
		for (LinkedList<Node<K, V>> e : temp) {
			for (Node<K, V> node : e) {
				put(node.getKey(), node.getValue());
			}
		}

	}

	public V get(K key) {
		int hc = hashFun(key);
		int index = getIndex(key, hc);
		if (index != -1) {
			for (Node<K, V> node : buckets[index]) {
				if (node.getKey().equals(key)) {
					return node.getValue();
				}
			}
		}
		return null;
	}

	public boolean containsKey(K key) {
		int hc = hashFun(key);
		int index = getIndex(key, hc);
		if (index != -1) {
			for (Node<K, V> node : buckets[index]) {
				if (node.getKey().equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<Node<K, V>> getEntrySet() {
		List<Node<K, V>> list = new ArrayList<>();
		for (LinkedList<Node<K, V>> e : buckets) {
			for (Node<K, V> node : e) {
				list.add(node);
			}
		}
		return list;
	}

}
