package binarysearchproblems;

public class FindIndexAtOfInsert {
	// https://leetcode.com/problems/search-insert-position/submissions/
	static int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int ans = 0;
		boolean flag = false;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				flag = true;
				ans = mid;
				end = mid - 1;
			}
		}
		if (!flag) {
			return nums.length;
		}
		return ans;
	}

	public static void main(String[] args) {

	}
}
