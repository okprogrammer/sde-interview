package tree.impl.bst;

import java.util.HashMap;
import java.util.Map;

public class CountOfDistinctElementOfWindowK {

	public int[] dNums(int[] A, int B) {
		int n = A.length;
		if (n < B) {
			return null;
		}
		int[] res = new int[n - B + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B; i++) {
			int key = A[i];
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		res[0] = map.size();
		int k = 1;
		for (int i = B; i < n; i++) {
			int key = A[i];
			if (map.containsKey(A[i - B])) {
				if (map.get(A[i - B]) == 1) {
					map.remove(A[i - B]);
				} else {
					map.put(A[i - B], map.get(A[i - B]) - 1);
				}
			}
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
			if (map.size() > B) {
				map.remove(A[i - B]);
			}
			res[k++] = map.size();
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
