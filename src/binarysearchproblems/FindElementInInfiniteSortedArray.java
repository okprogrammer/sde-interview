package binarysearchproblems;

import java.util.Arrays;

public class FindElementInInfiniteSortedArray {

	static int searchInInfiniteSortedArr(int[] input, int key) {
		int start = 0;
		int end = 1;
		while (key > input[end]) {
			start = end;
			end = 2 * end;
		}
		return Arrays.binarySearch(input, start, end, key);
	}

	static int searchFirstIndexInInfiniteSortedArr(int[] input, int key) {
		int start = 0;
		int end = 1;
		while (key > input[end]) {
			start = end;
			end = 2 * end;
		}
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (input[mid] == key) {
				ans = mid;
				end = mid - 1;
			}
			if (input[mid] < key) {
				start = mid + 1;
			} else if (input[mid] > key) {
				end = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int ans = searchFirstIndexInInfiniteSortedArr(input, 1);
		System.out.println(ans);
	}

}
