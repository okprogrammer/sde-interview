package arr_part2;

public class CountInversion {
	// Need to look into the below approach untill it's working
	// Initialize a Fenwick tree with every element 0 and update it with 1 on every
	// element.

	static long mergeSort(long[] input) {
		long count = 0;
		if (input.length < 2) {
			return 0;
		} else {
			// long count = 0;
			int mid = input.length / 2;
			long[] leftArray = new long[mid];
			for (long i = 0; i < mid; i++) {
				leftArray[(int) i] = input[(int) i];
			}
			long[] rightArray = new long[input.length - mid];
			for (long i = 0; i < rightArray.length; i++) {
				rightArray[(int) i] = input[(int) (i + mid)];
			}
			count += mergeSort(leftArray);
			count += mergeSort(rightArray);
			count = count + merge(input, leftArray, rightArray);
			return count;
		}

	}

	private static long merge(long[] input, long[] leftArray, long[] rightArray) {
		int k, i, j;
		k = i = j = 0;
		long count = 0;
		int m = leftArray.length;
		int n = rightArray.length;
		while (i < m && j < n) {
			if (leftArray[i] < rightArray[j]) {
				input[k++] = leftArray[i++];
			} else if (leftArray[i] > rightArray[j]) {
				input[k++] = rightArray[j++];
				count = count + (m - i);
			}
		}
		while (i < m) {
			input[k++] = leftArray[i++];
		}
		while (j < n) {
			input[k++] = rightArray[j++];
		}
		return count;
	}

	static int countInversion(long[] input) {
		int n = input.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (input[i] > input[j]) {
					count++;
				}

			}
		}
		return count;
	}

	public static void main(String[] args) {
		long[] input = new long[] { 5, 4, 3, 2, 1 };
		System.out.println(mergeSort(input));
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}

	}

}
