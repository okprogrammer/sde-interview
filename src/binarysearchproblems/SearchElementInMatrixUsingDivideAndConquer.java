package binarysearchproblems;

public class SearchElementInMatrixUsingDivideAndConquer {
	// we row and column are sorted and last row value is less than next row first
	// value
	static boolean searchKeyInMatrix(int[][] matrix, int target) {
		// no of columns
		int n = matrix.length;
		// no of rows
		int m = matrix[0].length;
		int start = 0;
		int end = (m * n) - 1;
		while (start <= end) {
			int mid = (start + (end - start) / 2);
			if (matrix[mid / m][mid % m] == target) {
				return true;
			} else if (matrix[mid / m][mid % m] < target) {
				start = mid + 1;
			} else if (matrix[mid / m][mid % m] > target) {
				end = mid - 1;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		boolean searchKeyInMatrix = searchKeyInMatrix(arr, 30);
		System.out.println(searchKeyInMatrix);
	}

}
