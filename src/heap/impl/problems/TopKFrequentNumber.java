package heap.impl.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumber {
	static int[] topKFrequent(int[] nums, int k) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int key = nums[i];
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
		// 1st approach
		// soring using comparator
//		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//			@Override
//			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//				if(o1.getValue() == o2.getValue()) {
//					return o2.getKey()-o1.getKey();
//				}
//				return o2.getValue()-o1.getValue();
//			}
//
//		});
		// 2nd approach - best approach
		// sorting using lambda expression
		// Collections.sort(list, (l1, l2) -> l2.getValue() - l1.getValue());
		// 3rd approach
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			pq.offer(e);
		}
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = pq.poll().getKey();
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 1, -1, 2, -1, 2, 3 };
		int[] arr = topKFrequent(nums, 2);
		for (int i = 0; i < 2; i++) {
			System.out.println(arr[i]);
		}

	}
}
