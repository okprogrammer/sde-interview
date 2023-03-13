package arr_part2;

import java.util.HashMap;
import java.util.Map;

public class findDuplicateInArray {

	public int findDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > 1) {
				return e.getKey();
			}
		}
		return -1;
	}

	static int findDuplicate2ndMethod(int[] nums) {
		int n = nums.length;
		int sum1 = 0;
		for (int i = 0; i < n; i++) {
			sum1 = sum1 + nums[i];
		}
		int sum2 = 0;
		for (int i = 1; i < n; i++) {
			sum2 = sum2 + i;
		}
		return Math.abs(sum2 - sum1);
	}

	static int findDuplicateDLoop(int[] nums) {
		int first = nums[0];
		int second = nums[0];
		do {
			first = nums[first];
			second = nums[nums[second]];
		} while (first != second);
		second = nums[0];
		while (first != second) {
			first = nums[first];
			second = nums[second];
		}
		return first;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 3, 4, 2, 2 };
		int ans = findDuplicateDLoop(input);
		System.out.println(ans);
	}

}
