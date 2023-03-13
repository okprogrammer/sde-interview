package arr_part1;

public class NextPermutation {

	public static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	static void reverse(int[] input, int start, int end) {
		while (start < end) {
			swap(input, start, end);
			start++;
			end--;
		}
	}

	static void nextPermutation(int[] nums) {
		int n = nums.length;
		int ind1 = -1;
		for (int i = n - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				ind1 = i - 1;
				break;
			}
		}
		if (ind1 == -1) {
			reverse(nums, 0, n - 1);
			return;
		}
		int ind2 = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] > nums[ind1]) {
				ind2 = i;
				swap(nums, ind1, ind2);
				break;
			}
		}
		reverse(nums, ind1 + 1, n - 1);

	}

	static void secondMethodNextPermutation(int[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		int i = input.length - 2;
		int j = input.length - 1;
		while (i >= 0 && input[i + 1] <= input[i]) {
			i--;
		}
		if (i >= 0) {
			while (j >= 0 && input[i] >= input[j]) {
				j--;
			}
			swap(input, i, j);
		}
		reverse(input, i + 1, input.length - 1);
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 3, 2, 4 };
		// 1 3 4 2
		// nextPermutation(input);
		secondMethodNextPermutation(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}

	}

}
