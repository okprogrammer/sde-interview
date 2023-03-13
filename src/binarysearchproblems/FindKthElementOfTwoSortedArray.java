package binarysearchproblems;

public class FindKthElementOfTwoSortedArray {

	static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
		if (n > m) {
			return kthElement(arr2, arr1, m, n, k);
		}
		int low = Math.max(0, k - m);
		int high = Math.min(k, n);
		while (low <= high) {
			int partition1 = (low + high) / 2;
			int partition2 = k - partition1;
			int maxLeftX = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
			int maxRightY = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
			int minRightX = (partition1 == n) ? Integer.MAX_VALUE : arr1[partition1];
			int minRightY = (partition2 == m) ? Integer.MAX_VALUE : arr2[partition2];
			if (maxLeftX <= minRightY && maxRightY <= minRightX) {
				return Math.max(maxLeftX, maxRightY);
			} else if (maxLeftX > minRightY) {
				high = partition1 - 1;
			} else {
				low = partition1 + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 10, 10, 25, 40, 54, 79 };
		int[] arr2 = new int[] { 15, 24, 27, 32, 33, 39, 48, 68, 82, 88, 90 };
		long ans = kthElement(arr1, arr2, arr1.length, arr2.length, 15);
		System.out.println(ans);
	}

}
