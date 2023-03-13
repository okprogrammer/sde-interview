package arr_part1;

import java.util.Arrays;
import java.util.Iterator;

public class SetMatrixZero {

	/**
	 * Given a matrix if an element in the matrix is 0 then you will have to set its
	 * entire column and row to 0 and then return the matrix.
	 */
	static void setZero(int[][] input, int i, int j) {
		int colIndex = input.length - 1;
		int rowIndex = input[0].length - 1;
		int first = i;
		int second = j;
		input[i][j] = 0;
		// make zero in up and forward
		while (first < rowIndex) {
			input[++first][j] = 0;
		}
		first = i;
		while (second < colIndex) {
			input[i][++second] = 0;
		}
		second = j;

		// make zero in down and backward
		while (first > 0) {
			input[--first][j] = 0;
		}
		first = i;
		while (second > 0) {
			input[i][--second] = 0;
		}
		second = j;

	}

	static int[][] findZero(int[][] input, int n) {
		int[][] result = new int[n][n];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = -1;
			}
		}
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				if (input[i][j] == 0) {
					setZero(result, i, j);
				} else if (result[i][j] != 0) {
					result[i][j] = input[i][j];
				}
			}
		}
		return result;
	}

	static void secondApproachMatrixSetZero(int[][] result) {
		int rows = result.length;
		int cols = result[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (result[i][j] == 0) {
					int ind = i + 1;
					// rows and column up and right
					while (ind < rows) {
						if (result[ind][j] > 0) {
							result[ind][j] = -1;
						}
						ind++;

					}
					ind = j + 1;
					while (ind < cols) {
						if (result[i][ind] > 0) {
							result[i][ind] = -1;
						}
						ind++;
					}

					// rows and column down and left

					// rows and column up and right
					ind = i - 1;
					while (ind >= 0) {
						if (result[ind][j] > 0) {
							result[ind][j] = -1;
						}
						ind--;

					}
					ind = j - 1;
					while (ind >= 0) {
						if (result[i][ind] > 0) {
							result[i][ind] = -1;
						}
						ind--;
					}

				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (result[i][j] < 0) {
					result[i][j] = 0;
				}

			}
		}
	}

	static void thirdApproachMatrixSetZero(int[][] input) {
		int rows = input.length;
		int cols = input[0].length;
		int[] X = new int[rows];
		for (int i = 0; i < X.length; i++) {
			X[i] = -1;
		}
		int[] Y = new int[cols];
		for (int i = 0; i < Y.length; i++) {
			Y[i] = -1;
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (input[i][j] == 0) {
					X[i] = 0;
					Y[j] = 0;
				}
			}
		}

		for (int i = 0; i < X.length; i++) {
			int c = 0;
			if (X[i] == 0) {
				while (c < cols) {
					input[i][c] = 0;
					c++;
				}

			}

		}
		for (int j = 0; j < Y.length; j++) {
			int r = 0;
			if (Y[j] == 0) {
				while (r < rows) {
					input[r][j] = 0;
					r++;
				}
			}
		}
	}

	static void fourthApproach(int[][] input) {
		int rows = input.length - 1;
		int cols = input[0].length - 1;
		for (int i = rows; i > 0; i--) {
			for (int j = cols; j > 0; j--) {
				if (input[i][j] == 0) {
					input[0][j] = 0;
					input[i][0] = 0;
				}
			}
		}
		for (int i = 0; i <= rows; i++) {
			int col = 1;
			if (input[i][0] == 0) {
				while (col <= cols) {
					if (input[i][col] > 0) {
						input[i][col] = -1;
					}

					col++;
				}
			}
		}
		for (int j = 0; j <= cols; j++) {
			int row = 1;
			if (input[0][j] == 0) {
				while (row <= rows) {
					if (input[row][j] > 0) {
						input[row][j] = -1;
					}

					row++;
				}
			}
		}
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= cols; j++) {
				if (input[i][j] < 0) {
					input[i][j] = 0;
				}

			}
		}
	}

	static void fifthApproach(int[][] input) {
		int rows = input.length;
		int cols = input[0].length;
		int[] X = new int[rows];
		int[] Y = new int[cols];
		Arrays.fill(X, -1);
		Arrays.fill(Y, -1);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (input[i][j] == 0) {
					X[i] = 0;
					Y[j] = 0;
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (X[i] == 0 || Y[j] == 0) {
					input[i][j] = 0;
				}
			}
		}
	}

	static void sixthApproach(int[][] input) {
		int rows = input.length;
		int cols = input[0].length;
		int col0 = -1;
		for (int i = 0; i < rows; i++) {
			if (input[i][0] == 0) {
				col0 = 0;
			}
			for (int j = 1; j < cols; j++) {
				if (input[i][j] == 0) {
					input[0][j] = 0;
					input[i][0] = 0;
				}
			}
		}
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 1; j--) {
				if (input[i][0] == 0 || input[0][j] == 0) {
					input[i][j] = 0;
				}
			}
			if (col0 == 0) {
				input[i][0] = 0;
			}
		}
	}

	static void setMatrixZero7th(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int col0 = -1;
		int row0 = -1;
		for (int i = 0; i < cols; i++) {
			if (matrix[0][i] == 0) {
				row0 = 0;
				 break;
			}
		}
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0) {
				col0 = 0;
				 break;
			}
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (row0 == 0) {
			for (int i = 0; i < cols; i++) {
				matrix[0][i] = 0;
			}
		}
		if (col0 == 0) {
			for (int j = 0; j < rows; j++) {
				matrix[j][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] result = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		// int[][] result = {{1,1,1},{1,0,1},{1,1,1}};
//		int[][] result = { { 1 }, { 0 } };
		// int[][] result = findZero(input, input.length);
		// secondApproachMatrixSetZero(result);
		// thirdApproachMatrixSetZero(result);
//		fifthApproach(result);
//		sixthApproach(result);
		setMatrixZero7th(result);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
