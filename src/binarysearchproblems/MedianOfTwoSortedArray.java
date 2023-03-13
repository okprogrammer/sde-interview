package binarysearchproblems;

public class MedianOfTwoSortedArray {

	// 1st approach
	static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] result = new int[m + n];
		mergeArray(result, nums1, nums2);
		int mn = result.length;
		double ans = 0;
		if (mn % 2 == 0) {
			ans = (result[mn / 2] + result[mn / 2 + 1]) / 2.0;
		} else {
			ans = result[mn / 2];
		}
		return ans;
	}

	static void mergeArray(int[] result, int[] nums1, int[] nums2) {
		int i, j, k;
		i = j = k = 0;
		int m = nums1.length;
		int n = nums2.length;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				result[k++] = nums1[i];
				i++;
			} else {
				result[k++] = nums2[j];
				j++;
			}
		}
		while (i < m) {
			result[k++] = nums1[i++];
		}
		while (j < n) {
			result[k++] = nums2[j++];
		}
	}

	// 2nd approach
	static double findMedianOfSortedArr(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int x = nums1.length;
		int y = nums2.length;
		int low = 0;
		int high = x;
		while (low <= high) {
			// find nums1 partition
			int partitionX = (low + high) / 2;
			// find nums2 partition
			int partitionY = (x + y + 1) / 2 - partitionX;
			// if partionX == 0, that means there is no partition in left side
			// max value of left partition
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			// if partitionX == x, that means it is at boundary
			// min value of left partition
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
			// if partionY == 0, that means there is no partition in right side
			// max value of right partition
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			// if partitionY == y, that means it is at boundary
			// min value of right parition
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
			// check the right partition
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
				} else {
					return Math.max(maxLeftX, maxLeftY) * 1.0;
				}
			} else if (maxLeftX > minRightY) {// we are too far on the right side we have to move to left side
				high = partitionX - 1;
			} else { // we are too far on left side- we have to move to right side
				low = partitionX + 1;
			}
		}
		return 1.0;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 4, 7, 10, 12 };
		int[] nums2 = new int[] { 2, 3, 6, 15 };
		double ans = findMedianOfSortedArr(nums1, nums2);
		System.out.println(ans);
	}
}
