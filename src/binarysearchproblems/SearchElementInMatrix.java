package binarysearchproblems;

import java.lang.Integer;

public class SearchElementInMatrix {
	static boolean searchKeyInMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int i = 0;
		int j = m - 1;
		while (i >= 0 && i < n && j >= 0 && j < m) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				j--;
			} else if (matrix[i][j] < target) {
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
	}

}
