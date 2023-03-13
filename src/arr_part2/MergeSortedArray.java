package arr_part2;

import java.util.Arrays;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int j = 0;
		int k = 0;
		if (nums1.length < 1 || nums2.length < 1) {
			return;
		}
		for (int i = 0; i < m; i++) {
			if (nums1[i] > nums2[0]) {
				int temp = nums1[i];
				nums1[i] = nums2[0];
				nums2[0] = temp;
			}
			// int first = nums2[0];
			// for(j=1;j<n && first>nums2[j];j++) {
			// nums2[j-1] = nums2[j];
			// }
			// nums2[n-1] = first;
			Arrays.sort(nums2);
		}

		for (int x = m; x < m + n; x++) {
			nums1[x] = nums2[k++];
		}

	}

	static void merge2nd(int[] nums1, int m, int[] nums2, int n) {
		int j = 0;
		int k = 0;
		if (nums1.length < 1 || nums2.length < 1) {
			return;
		}
		for (int i = 0; i < m; i++) {
			if (nums1[i] > nums2[0]) {
				int temp = nums1[i];
				nums1[i] = nums2[0];
				nums2[0] = temp;
			}
			int first = nums2[0];
			for (j = 1; j < n && first > nums2[j]; j++) {
				nums2[j - 1] = nums2[j];
			}
			nums2[j - 1] = first;
			// Arrays.sort(nums2);
		}

		for (int x = m; x < n+m; x++) {
			nums1[x] = nums2[k++];
		}

	}

	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] arr2 = new int[] { 2, 5, 6 };
		merge2nd(arr1, 3, arr2, 3);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

	}

}
