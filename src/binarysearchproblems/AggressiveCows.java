package binarysearchproblems;

import java.util.Arrays;

public class AggressiveCows {

	static int arrangeCows(int[] stalls, int cows) {
		Arrays.sort(stalls);
		int n = stalls.length;
		int start = 0;
		int end = (stalls[n - 1] - stalls[0]);
		int ans = Integer.MIN_VALUE;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (isFeasible(stalls, cows - 1, mid)) {
				ans = Math.max(ans, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	private static boolean isFeasible(int[] stalls, int cows, int mid) {
		int n = stalls.length;
		int lastPlacedCow = stalls[0];
		for (int i = 1; i < n; i++) {
			if ((stalls[i] - lastPlacedCow) >= mid) {
				lastPlacedCow = stalls[i];
				cows--;
			}
		}
		return cows > 0 ? false : true;
	}

	public static void main(String[] args) {
		int[] stalls = new int[] { 1, 2, 4, 8, 9 };
		int cows = 3;
		int ans = arrangeCows(stalls, cows);
		System.out.println(ans);
	}

}
