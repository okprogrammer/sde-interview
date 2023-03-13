package arr_part1;

import java.util.HashMap;
import java.util.Map;

public class SortOneTwoZero {

	static void sortOneTwoZeroThreePointerApproach(int[] nums) {
		int start = 0;
		int mid = 0;
		int end = nums.length - 1;
		while (mid <= end) {
			if (nums[mid] == 0) {
				swap(nums, start, mid);
				start++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				swap(nums, mid, end);
				end--;
			}

		}
	}

	static void sortOneTwoZeroCountApproach(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int key = nums[i];
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		int countZero = 0;
		if (map.get(0) != null) {
			countZero = map.get(0);
		}
		int countOne = 0;
		if (map.get(1) != null) {
			countOne = map.get(1);
		}
		int counTwo = 0;
		if (map.get(2) != null) {
			counTwo = map.get(2);
		}

		int k = 0;
		while (countZero > 0) {
			nums[k++] = 0;
			countZero--;
		}
		while (countOne > 0) {
			nums[k++] = 1;
			countOne--;
		}
		while (counTwo > 0) {
			nums[k++] = 2;
			counTwo--;
		}
	}

	private static void swap(int[] input, int startIndex, int endIndex) {
		int temp = input[startIndex];
		input[startIndex] = input[endIndex];
		input[endIndex] = temp;

	}

	public static void main(String[] args) {
		int[] input = { 2, 0, 2, 1, 1, 0 };
		sortOneTwoZeroThreePointerApproach(input);
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}

	}

}
