package arr_part3;

import java.util.Arrays;

public class SearchIn2DMatrix {

	// Intution is to check first and last element of each row
	// then taking whole row
	// and applying binary search
	static boolean searchInTwoDMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			int m = matrix[i].length;
			if (matrix[i][0] <= target && matrix[i][m - 1] >= target) {
				int[] arr = matrix[i];
				int index = Arrays.binarySearch(arr, target);
				if (index >= 0) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean searchInTwoDMatrixApplyBinarySearch(int[][] matrix, int target) {
		int n = matrix.length;
		if (n == 0) {
			return false;
		}
		int m = matrix[0].length;
		int lo = 0;
		int hi = (m * n) - 1;
		while (lo <= hi) {
			int mid = (lo + (hi-lo)/2);
			if (matrix[mid / m][mid % m] < target) {
				lo = mid + 1;
			} else if (matrix[mid / m][mid % m] > target) {
				hi = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
	
	static boolean GFGApproach(int[][] matrix, int target) {
		int i =0;
		int m = matrix.length;
		int n = matrix[0].length;
		int j = n-1;
		while(i<m && j>=0) {
			if(matrix[i][j] == target) {
				return true;
			}else if(matrix[i][j] >target ) {
				j--;
			}else if(matrix[i][j]<target) {
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
//		int[][] arr = { { 1 } };
		System.out.println(searchInTwoDMatrixApplyBinarySearch(arr, 11));
	}

}
