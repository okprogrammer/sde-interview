package arr_part3;

public class CountReversePair {

	static int reversePairs(int[] nums) {
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((long) nums[i] > (long) 2 * nums[j]) {
					count++;
				}
			}
		}
		return count;
	}

	static int mergeSort(int[] input) {
		if (input.length < 2) {
			return 0;
		}
		int mid = input.length / 2;
		int[] leftArray = new int[mid];
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = input[i];
		}
		int[] rightArray = new int[input.length - mid];
		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = input[i + mid];
		}
		int count = 0;
		count += mergeSort(leftArray);
		count += mergeSort(rightArray);
		count += merge(input, leftArray, rightArray);
		return count;
	}

	private static int merge(int[] input, int[] leftArray, int[] rightArray) {
		int i = 0;
		int j = 0;
		int k = 0;
		int m = leftArray.length;
		int n = rightArray.length;
		int cnt = 0;
		while (i < m) {
			while (j < n && (long)leftArray[i] >(long) 2 * rightArray[j]) {
				j++;
				cnt = cnt + (m - i);
			}
			i++;
		}
		i = j = k = 0;
		while (i < m && j < n) {
			if (leftArray[i] < rightArray[j]) {
				input[k++] = leftArray[i++];
			} else {
				input[k++] = rightArray[j++];
			}
		}
		while (i < m) {
			input[k++] = leftArray[i++];
		}
		while (j < n) {
			input[k++] = rightArray[j++];
		}
		return cnt;
	}
	
	static int improvedReversePairSum(int[] nums) {
		return mergeSort(nums);
	}

	public static void main(String[] args) {
		// Supplier<T>
		int[] input = new int[] { 40, 25, 19, 12, 9, 6, 2 };
		System.out.println(reversePairs(input));

		System.out.println("hello " + improvedReversePairSum(input));
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}

	}

}
