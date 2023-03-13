package arr_part3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		int n = nums.length;
		int m = n / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int key = nums[i];
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > m) {
				return e.getKey();
			}
		}
		return 0;
	}

	// If Majority Element always be present
	public static int majaorityElement2nd(int[] nums) {
		int count = 0;
		int candidate = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (count == 0) {
				candidate = nums[i];
			}
			if (candidate == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return count;
	}

	static List<Integer> majoritElementNByThree(int[] nums) {
		int count1 = 0;
		int count2 = 0;
		int c1 = -1;
		int c2 = -1;
		int n = nums.length;
		for (int i : nums) {
			if (c1 == i) {
				count1++;
			} else if (c2 == i) {
				count2++;
			} else if (count1 == 0) {
				c1 = i;
				count1 = 1;
			} else if (count2 == 0) {
				c2 = i;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = count2 = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == c1) {
				count1++;
			} else if (nums[i] == c2) {
				count2++;
			}
		}
		List<Integer> list = new ArrayList<>();
		if (count1 > n / 3) {
			list.add(c1);
		}
		if (count2 > n / 3) {
			list.add(c2);
		}
		return list;
	}

	public static void main(String[] args) {
		int[] input = { 2, 1, 1, 3, 1, 4, 5, 6 };
		System.out.println(majoritElementNByThree(input));
	}

}
