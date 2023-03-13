package arr_part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solutions {

	static int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		int[] arr = new int[2];
		for (int i = 0; i < n; i++) {
			int sum = nums[i];
			for (int j = i + 1; j < n; j++) {
				if (target == sum + nums[j]) {
					arr[0] = i;
					arr[1] = j;
					return arr;
				}
			}
		}
		return null;
	}

	static int[] twoSumImprove(int[] nums, int target) {
		int n = nums.length;
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = nums[i];
		}
		Arrays.sort(input);
		int i = 0;
		int j = nums.length - 1;
		int first = 0;
		int second = 0;

		while (i < j) {
			int sum = input[i] + input[j];
			if (sum == target) {
				first = input[i];
				second = input[j];
				break;
			}
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			}
		}
		int[] arr = new int[2];
		boolean flag = false;
		for (int k = 0; k < n; k++) {
			if (!flag && first == nums[k]) {
				arr[0] = k;
				flag = true;
			}
			if (second == nums[k]) {
				arr[1] = k;
			}
		}
		return arr;
	}

	static int[] twoSumUsingHashing(int[] nums, int target) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		int firstKey = -1;
		int secondKey = -1;
		for (int i = 0; i < nums.length; i++) {
			int x = target - nums[i];
			if (!map.containsValue(x)) {
				map.put(i, nums[i]);
			} else {
				firstKey = i;
				secondKey = findKey(nums, x);
				break;
			}
		}
		if (firstKey < secondKey) {
			return new int[] { firstKey, secondKey };
		}
		return new int[] { secondKey, firstKey };
	}

	private static int findKey(int[] nums, int x) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == x) {
				return i;
			}
		}
		return -1;
	}

	static List<List<Integer>> fourSum(int[] nums, int target) {
		int n = nums.length;
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nums[i];
		}
		Arrays.sort(arr);
		Set<List<Integer>> list = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int j2 = j + 1; j2 < n; j2++) {
					long search = ((long) target - ((long) arr[i] + (long) arr[j] + (long) arr[j2]));
					int index = Arrays.binarySearch(arr, j2 + 1, n, search);
					if (index >= 0) {
						List<Integer> newList = new ArrayList<>();
						newList.add((int) arr[i]);
						newList.add((int) arr[j]);
						newList.add((int) arr[j2]);
						newList.add((int) arr[index]);
						Collections.sort(newList);
						list.add(newList);
					}
				}
			}
		}
		List<List<Integer>> collect = list.stream().collect(Collectors.toList());
		return collect;
	}

	static List<List<Integer>> optimizeFourSum(int[] nums, int target) {
		int n = nums.length;
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = nums[i];
		}
		Arrays.sort(arr);
		Set<List<Integer>> list = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				long parTarget = (long) target - (arr[i] + arr[j]);
				int front = j + 1;
				int end = n - 1;
				while (front < end) {
					long twoSum = arr[front] + arr[end];
					if (twoSum > parTarget) {
						end--;
					} else if (twoSum < parTarget) {
						front++;
					} else if (twoSum == parTarget) {
						List<Integer> arrList = new ArrayList<>();
						arrList.add((int) arr[i]);
						arrList.add((int) arr[j]);
						arrList.add((int) arr[front]);
						arrList.add((int) arr[end]);
						list.add(arrList);
						front++;
						end--;
					}
				}
			}
		}
		List<List<Integer>> ans = list.stream().collect(Collectors.toList());
		return ans;
	}

	static List<List<Integer>> littleMoreOptimizeFourSum(int[] nums, int target) {
		int n = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		if (n == 0 || nums == null) {
			return list;
		}
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = nums[i];
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			long target1 = target - arr[i];
			for (int j = i + 1; j < n; j++) {
				long parTarget = target1 - arr[j];
				int front = j + 1;
				int end = n - 1;
				while (front < end) {
					long twoSum = arr[front] + arr[end];
					if (twoSum > parTarget) {
						end--;
					} else if (twoSum < parTarget) {
						front++;
					} else {
						List<Integer> arrList = new ArrayList<>();
						arrList.add((int) arr[i]);
						arrList.add((int) arr[j]);
						arrList.add((int) arr[front]);
						long temp1 = arr[front];
						arrList.add((int) arr[end]);
						long temp2 = arr[end];
						list.add(arrList);
						while (front < end && nums[front] == temp1) {
							++front;
						}
						while (front < end && nums[end] == temp2) {
							--end;
						}
					}
				}
				while (j + 1 < n && nums[j + 1] == nums[j]) {
					++j;
				}
			}
			while (i + 1 < n && nums[i + 1] == nums[i]) {
				++i;
			}
		}
		// List<List<Integer>> ans = list.stream().collect(Collectors.toList());
		return list;
	}

	public static int longestConsecutive(int[] nums) {
		int maxCount = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			set.add(nums[i]);
		}
		for (int i : set) {
			int currentNum = i;
			int count = 1;
			if (!set.contains(currentNum - 1)) {
				while (set.contains(currentNum + 1)) {
					currentNum++;
					count++;
				}
				if (count > maxCount) {
					maxCount = count;
				}

			}

		}
		return maxCount;
	}

	static int maxLen(int arr[], int n) {
		int maxStreak = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = arr[i];
				int count = 1;
				for (int k = i + 1; k <= j; k++) {
					sum = sum + arr[k];
					count++;
				}
				if (sum == 0 && count > maxStreak) {
					maxStreak = count;
				}
			}
		}
		return maxStreak;
	}

	static int maxLenN2(int arr[], int n) {
		int maxStreak = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum = sum + arr[j];
				if (sum == 0) {
					maxStreak = Math.max(maxStreak, j - i + 1);
				}
			}
		}
		return maxStreak;
	}

	// find the largest subset length which sum is zero
	static int maxLenOptimize(int arr[], int n) {
		int sum = 0;
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
			if (sum == 0) {
				max = i + 1;
			} else {
				if (map.containsKey(sum)) {
					max = Math.max(max, i - map.get(sum));
				} else {
					map.put(sum, i);
				}
			}

		}
		return max;
	}

	static int XORCountToB(int[] A, int B) {
		int n = A.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int currentXor = 0;
			for (int j = i; j < n; j++) {
				currentXor = currentXor ^ A[j];
				if (currentXor == B) {
					count++;
				}
			}
		}
		return count;
	}

	static int XORCountToBOptimize(int[] A, int B) {
		int n = A.length;
		int count = 0;
		int curXor = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			curXor = curXor ^ A[i];
			int k = curXor ^ B;
			if (map.containsKey(k)) {
				count = count + map.get(k);
			}
			if (curXor == B) {
				count++;
			}
			if (map.containsKey(curXor)) {
				map.put(curXor, map.get(curXor) + 1);
			} else {
				map.put(curXor, 1);
			}
		}
		return count;
	}

	static int lengthOfLongestSubstring(String s) {
		String ans = "";
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int count = 0;
		int maxCount = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (ans.contains(s.charAt(i) + "")) {
				int index = ans.indexOf(s.charAt(i) + "");
				ans = ans.substring(index + 1) + s.charAt(i);
				count = ans.length();
				if (maxCount < count) {
					maxCount = count;
				}
			} else {
				ans = ans + s.charAt(i);
				count++;
				if (maxCount < count) {
					maxCount = count;
				}
			}
		}
		return maxCount;
	}

	static int lengthOfLongestSubstringOptimize(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int count = 0;
		int l = 0;
		for (int r = 0; r < n; r++) {
			char searchChar = s.charAt(r);
			while (l < r && set.contains(searchChar)) {
				set.remove(s.charAt(l));
				l++;
			}
			set.add(searchChar);
			count = Math.max(count, r - l + 1);
		}
		return count;
	}

	static int lengthOfLongestSubstringOptimize2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		int r = 0;
		int l = 0;
		while (r < n) {
			char searchKey = s.charAt(r);
			if (map.containsKey(searchKey)) {
				l = Math.max(map.get(searchKey) + 1, l);
			}
			map.put(s.charAt(r), r);
			maxLen = Math.max(maxLen, r-l+1);
			r++;
		}
		return maxLen;
	}

	public static void main(String[] args) {
//		int[] nums = new int[] { 3, 2, 4 };
//		List<List<Integer>> fourSum = optimizeFourSum(new int[] { 2, 1, 0, -1 }, 2);
//		System.out.println(fourSum);
//		int[] input = new int[] { 100, 4, 200, 1, 3, 2 };
//		System.out.println(longestConsecutive(input));
//		int[] arr = new int[] { 9, -3, 3, -1, 6, -5 };
//		System.out.println(maxLenOptimize(arr, 6));
//		int[] arr = { 4, 2, 2, 6, 4 };
//		System.out.println(XORCountToBOptimize(arr, 6));
		String input = "abcabcdb";
		System.out.println(lengthOfLongestSubstringOptimize2(input));
	}

}
