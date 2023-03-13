package binarysearchproblems;

public class NearlySortedArray {

	static int nearlySortedArr(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (mid > start && nums[mid - 1] == target) {
				return mid - 1;
			} else if (mid < end && nums[mid + 1] == target) {
				return mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 5, 10, 30, 20, 40 };
		int ans = nearlySortedArr(nums, 5);
		System.out.println(ans);
	}
}
