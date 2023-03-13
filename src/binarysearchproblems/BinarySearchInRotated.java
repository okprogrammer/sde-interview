package binarysearchproblems;

import java.time.Instant;

public class BinarySearchInRotated {
	static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			// check left part is sorted or not
			if (nums[start] <= nums[mid]) {
				if (nums[start] <= target && nums[mid] >= target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (nums[mid] <= target && nums[end] >= target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;

	}

	// find no of rotation in array
	// we will ans in unsorted part half
	static int noOfRotation(int[] input) {
		int N = input.length;
		int start = 0;
		int end = N - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int next = (mid + 1) % N;
			int prev = (mid - 1 + N) % N;
			if (input[mid] <= input[prev] && input[mid] <= input[next]) {
				return mid;
			} else if (input[mid] <= input[end]) {
				end = mid - 1;
			} else if (input[start] <= input[mid]) {
				start = mid + 1;
			}
		}
		return 0;
	}

	static int searchInRotatedArr(int[] input, int target) {
		int minIndex = noOfRotation(input);
		int n = input.length - 1;
		int firstPart = binarySearch(input, target, 0, minIndex - 1);
		int secondPart = binarySearch(input, target, minIndex, n - 1);
		if (firstPart == -1 && secondPart == -1) {
			return -1;
		}
		return firstPart == -1 ? secondPart : firstPart;
	}

	private static int binarySearch(int[] input, int target, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (input[mid] == target) {
				return mid;
			} else if (input[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	// with duplicated value find using binary search
	static boolean searchKeyInArray(int[] nums, int target) {
		int N = nums.length;
		int start = 0;
		int end = N - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			}
			// duplicate case
			if ((nums[start] == nums[mid]) && (nums[mid] == nums[end])) {
				start++;
				end--;
			} else if (nums[start] <= nums[mid]) {
				if (nums[start] <= target && nums[mid] > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (nums[mid] < target && nums[end] >= target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 2, 2, 2, 0, 2, 2 };
//		int index = search(input, 0);
//		System.out.println(index);
//		int noOfRotation = noOfRotation(input);
//		System.out.println(noOfRotation);
		int searchInRotatedArr = searchInRotatedArr(input, 0);
		System.out.println(searchInRotatedArr);
	}

}
