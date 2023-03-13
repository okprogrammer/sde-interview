package binarysearchproblems;

/**
 * The Class MatrixMedian.
 */
public class MatrixMedian {

	/**
	 * Find median. Need to understand in more clarity
	 *
	 * @param A the a
	 * @return the int
	 */
	public static int findMedian(int[][] A) {
		int start = 1;
		int end = (int) 1e9;
		int m = A.length;
		int n = A[0].length;
		int mm = (m*n)/2;
		while (start <= end) {
			int mid = (start + end) >> 1;
			int count = 0;
			for (int i = 0; i < m; i++) {
				count += findNoCount(A[i], mid);
			}
			if (count <= mm) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	/**
	 * Find no count.
	 *
	 * @param arr the arr
	 * @param key the key
	 * @return the int
	 */
	private static int findNoCount(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (arr[mid] <= key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[][] input = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		System.out.println(findMedian(input));
	}

}
