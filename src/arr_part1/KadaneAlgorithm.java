package arr_part1;

import java.util.Arrays;
import java.util.Iterator;

public class KadaneAlgorithm {

	static int[] maxSumN3(int[] input) {
		int[] arr = null;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				int sum = input[i];
				for (int k = i + 1; k <= j; k++) {
					sum = sum + input[k];
				}
				if (sum > maxSum) {
					maxSum = sum;
					arr = Arrays.copyOfRange(input, i, j + 1);
				}
			}
		}
		return arr;

	}

	static int[] maxSumN2(int[] input) {
		int[] arr = null;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			int sum = input[i];
			for (int j = i; j < input.length; j++) {
				sum += input[j];
				if (sum > maxSum) {
					maxSum = sum;
					arr = Arrays.copyOfRange(input, i, j + 1);
				}
			}
		}
		return arr;

	}

	static int maxSumN(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			maxSum = Math.max(sum, maxSum);
			if (sum < 0) {
				sum = 0;
			}

		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int sum = maxSumN(arr);
		System.out.println(sum);

//		for (int i = 0; i < arr.length; i++) {
//			sum = sum + arr[i];
//		}
		System.out.println(sum);
	}

}
