package heap.impl.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> arr = kArrays.get(i);
			for (int j = 0; j < arr.size(); j++) {
				pq.add(arr.get(j));
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		int n = pq.size();
		for (int i = 0; i < n; i++) {
			ans.add(pq.poll());
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			a.add((int) (Math.random() * 100 + 1));
		}
		ArrayList<Integer> b = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			b.add((int) (Math.random() * 100 + 1));
		}
		ArrayList<Integer> c = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			c.add((int) (Math.random() * 100 + 1));
		}
		Collections.sort(a);
		Collections.sort(b);
		Collections.sort(c);
		list.add(a);
		// System.out.println(a);
		list.add(b);
		list.add(c);
		ArrayList<Integer> mergeKSortedArrays = mergeKSortedArrays(list, 3);
		for (int i = 0; i < mergeKSortedArrays.size(); i++) {
			System.out.println(mergeKSortedArrays.get(i));
		}
		System.out.println("Hello");
	}

}
