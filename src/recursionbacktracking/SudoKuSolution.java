package recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class SudoKuSolution {

	static void solveSudoku(char[][] board) {
		solve(board);
	}

	static boolean solve(char[][] board) {
		int n = board.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(i, j, board, c)) {
							board[i][j] = c;
							if (solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	static boolean isValid(int row, int col, char[][] board, char c) {
		for (int k = 0; k < 9; k++) {
			if (board[row][k] == c || board[k][col] == c || board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == c) {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = { { '.', '4', '.', '1', '5', '.', '.', '8', '3' },
				{ '.', '3', '.', '.', '6', '.', '5', '.', '.' }, { '6', '.', '.', '.', '.', '.', '.', '.', '9' },
				{ '.', '5', '.', '.', '.', '.', '.', '.', '.' }, { '1', '.', '.', '7', '.', '8', '.', '.', '2' },
				{ '.', '.', '.', '.', '.', '.', '.', '6', '.' }, { '5', '.', '.', '.', '.', '.', '.', '.', '4' },
				{ '.', '.', '4', '.', '8', '.', '.', '7', '.' }, { '8', '6', '.', '.', '2', '4', '.', '9', '.' } };
		solve(board);
		List<List<Character>> list = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
