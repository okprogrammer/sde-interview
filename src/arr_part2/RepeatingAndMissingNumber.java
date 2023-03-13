package arr_part2;

import java.util.Iterator;

public class RepeatingAndMissingNumber {

	static int[] repeatedAndMissing(int[] nums) {
		int n = nums.length;
		int[] freq = new int[n + 1];
		for (int i = 0; i < n; i++) {
			freq[nums[i]]++;
		}
		int repeat = -1;
		int missing = -1;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 1) {
				repeat = i;
			} else if (freq[i] == 0) {
				missing = i;
			}
		}
		return new int[] { repeat, missing };
	}

	static int[] repeatedAndMissingEquation(int[] nums) {
		int n = nums.length;
		int sum = 0;
		int prod = 1;
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			prod = prod * nums[i];
		}
		int Nsum = (int) ((n * (n + 1)) / 2);
		int Nprod = fact(n);
		int repeat = ((Nsum - sum) * prod) / (Nprod - prod);
		int missing = (int) (Nprod * repeat) / prod;
		return new int[] { repeat, missing };
	}

	private static int fact(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}

	static int[] repeatedAndMissingTrack(int[] nums) {
		int n = nums.length;
		boolean[] freq = new boolean[n + 1];
		int repeat = -1;
		int missing = -1;
		for (int i = 0; i < n; i++) {
			if (!freq[nums[i]]) {
				freq[nums[i]] = true;
			} else {
				repeat = nums[i];
			}
		}
		for (int i = 1; i < freq.length; i++) {
			if (!freq[i]) {
				missing = i;
			}
		}
		return new int[] { repeat, missing };
	}

	static void getTwoElements(int arr[], int n) {
		/*
		 * Will hold xor of all elements and numbers from 1 to n
		 */
		int xor1;

		/* Will have only single set bit of xor1 */
		int set_bit_no;

		int i;
		int x = 0;
		int y = 0;

		xor1 = arr[0];

		/* Get the xor of all array elements */
		for (i = 1; i < n; i++)
			xor1 = xor1 ^ arr[i];

		/*
		 * XOR the previous result with numbers from 1 to n
		 */
		for (i = 1; i <= n; i++)
			xor1 = xor1 ^ i;

		/* Get the rightmost set bit in set_bit_no */
		set_bit_no = xor1 & ~(xor1 - 1);

		/*
		 * Now divide elements into two sets by comparing rightmost set bit of xor1 with
		 * the bit at the same position in each element. Also, get XORs of two sets. The
		 * two XORs are the output elements. The following two for loops serve the
		 * purpose
		 */
		for (i = 0; i < n; i++) {
			if ((arr[i] & set_bit_no) != 0)
				/* arr[i] belongs to first set */
				x = x ^ arr[i];

			else
				/* arr[i] belongs to second set */
				y = y ^ arr[i];
		}
		for (i = 1; i <= n; i++) {
			if ((i & set_bit_no) != 0)
				/* i belongs to first set */
				x = x ^ i;

			else
				/* i belongs to second set */
				y = y ^ i;
		}

		// at last do a linear check which amont x and y is missing or repeating

		/* *x and *y hold the desired output elements */
		System.out.println(x + " " + y);
	}

	static int[] repeatAndMissingUsingXor(int[] nums) {
		int xor1 = nums[0];
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			xor1 = xor1 ^ nums[i];
		}
		for (int i = 1; i <= n; i++) {
			xor1 = xor1 ^ i;
		}
		int set_bit = xor1 & (~(xor1 - 1));
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			if ((nums[i] & set_bit) != 0) {
				x = x ^ nums[i ];
			} else {
				y = y ^ nums[i];
			}
		}
		for (int i = 1; i <= n; i++) {
			if ((i & set_bit) != 0) {
				x = x ^ i;
			} else {
				y = y ^ i;
			}
		}
		for (int i = 0; i < n; i++) {
			if(nums[i] == x) {
				break;
			}else if(nums[i] == y) {
				int temp = y;
				y = x;
				x = temp;
			}
			
		}
		return new int[] { x, y };
	}

	static int[] repeatAndMissingSignBit(int[] nums) {
		int repeat = 0;
		int missing = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int x = Math.abs(nums[i]) - 1;
			if (nums[x] < 0) {
				repeat = x + 1;
			} else {
				nums[x] *= -1;
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				missing = i + 1;
			}
		}
		return new int[] { repeat, missing };
	}
	

	public static void main(String[] args) {
		int array[] = { 1, 3, 3, 4 };

		int[] ans = repeatAndMissingUsingXor(array);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
