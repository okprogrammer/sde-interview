package practice;

public class MergeSort {

	static void mergeSort(int[] input) {
		if (input.length < 2) {
			return;
		}
		int mid = input.length / 2;
		int[] leftArray = new int[mid];
		for (int i = 0; i < mid; i++) {
			leftArray[i] = input[i];
		}
		int[] rightArray = new int[input.length - mid];
		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = input[i + mid];
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(input, rightArray, leftArray);
	}

	private static void merge(int[] input, int[] rightArray, int[] leftArray) {
		int k, i, j;
		k = i = j = 0;
		int m = leftArray.length;
		int n = rightArray.length;
		while (i < m && j < n) {
			if (leftArray[i] < rightArray[j]) {
				input[k++] = leftArray[i++];
			} else if (leftArray[i] >= rightArray[j]) {
				input[k++] = rightArray[j++];
			}
		}
		while (i < m) {
			input[k++] = leftArray[i++];
		}
		while (j < n) {
			input[k++] = rightArray[j++];
		}

	}

	public static void main(String[] args) {
		int[] input = new int[] { 5, 4, 3, 2, 1,-99,1,3,6 };
		mergeSort(input);
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}

}
