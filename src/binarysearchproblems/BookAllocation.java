package binarysearchproblems;

import java.util.Arrays;

public class BookAllocation {

	static int books(int[] A, int B) {
		if (B > A.length) {
			return -1;
		}
		// Arrays.sort(A);
		long sum = 0;
		int n = A.length;
		int min = -1;
		for (int i = 0; i < n; i++) {
			sum += A[i];
			min = Math.max(min, A[i]);
		}
		int max = (int) sum;
		int res = Integer.MAX_VALUE;
		while (max >= min) {
			int mid = (min + max) >> 1;
			if (isFeasible(A, mid, B)) {
				res = Math.min(mid, res);
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return res;
	}

	static boolean isFeasible(int[] a, int pages, int students) {
		int sum = 0;
		int n = a.length;
		int k = 1;
		for (int i = 0; i < n; i++) {
			if (a[i] > pages) {
				return false;
			}
			if ((sum + a[i]) > pages) {
				sum = a[i];
				k++;
			} else {
				sum += a[i];
			}
		}
		return k <= students;
	}

	public static void main(String[] args) {
		int[] arr = { 9, 23, 30, 44, 58, 72, 73, 78 };
		int ans = books(arr, 5);
		System.out.println(ans);
	}

}
