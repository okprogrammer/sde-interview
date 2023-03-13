package binarysearchproblems;

public class FindPeakElementInArray {

	static int findPeakElement(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int n = nums.length - 1;
		if (end == 0) {
			return 0;
		}
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid > 0 && mid < n) {
				if (nums[mid - 1] <= nums[mid] && nums[mid + 1] <= nums[mid]) {
					return mid;
				} else if (nums[mid - 1] > nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (mid == 0) {
				if (nums[mid] > nums[mid + 1]) {
					return mid;
				} else {
					return mid + 1;
				}
			} else if (mid == n) {
				if (nums[mid - 1] > nums[mid]) {
					return mid - 1;
				} else {
					return mid;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 1 };
		int ans = findPeakElement(nums);
		System.out.println(ans);
	}

}
