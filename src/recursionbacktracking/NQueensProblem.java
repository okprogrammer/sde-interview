package recursionbacktracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class NQueensProblem.
 */
public class NQueensProblem {

	/**
	 * Solve N queens.
	 *
	 * @param n the n
	 * @return the list
	 */
	static List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new ArrayList<>(n);
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		solveNQueens(ans, board, n, 0);
		return ans;
	}

	/**
	 * Solve N queens.
	 *
	 * @param ans   the ans
	 * @param board the board
	 * @param n     the n
	 * @param row   the row
	 */
	static void solveNQueens(List<List<String>> ans, char[][] board, int n, int row) {
		if (row == n) {
			ans.add(construct(board));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isSafe(board, row, col, n)) {
				board[row][col] = 'Q';
				solveNQueens(ans, board, n, row + 1);
				board[row][col] = '.';
			}
		}

	}

	/**
	 * Construct.
	 *
	 * @param board the board
	 * @return the list
	 */
	private static List<String> construct(char[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			res.add(new String(board[i]));
		}
		return res;
	}

	/**
	 * Checks if is safe.
	 *
	 * @param board the board
	 * @param row   the row
	 * @param col   the col
	 * @param n     the n
	 * @return true, if is safe
	 */
	private static boolean isSafe(char[][] board, int row, int col, int n) {
		// for row and col
		for (int i = 0; i < n; i++) {
			if (board[row][i] == 'Q' || board[i][col] == 'Q') {
				return false;
			}
		}
		// for diagonal
		for (int i = 0; i < n; i++) {
			// left upward diagonal movement
			if (inbound(row - i, col - i, n) && board[row - i][col - i] == 'Q') {
				return false;
			}
			// right upward diagonal movement
			if (inbound(row - i, col + i, n) && board[row - i][col + i] == 'Q') {
				return false;
			}
			// left downward diagonal movement
			if (inbound(row + i, col - i, n) && board[row + i][col - i] == 'Q') {
				return false;
			}
			// right downward diagonal movement
			if (inbound(row + i, col + i, n) && board[row + i][col + i] == 'Q') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Inbound.
	 *
	 * @param row the row
	 * @param col the col
	 * @param n   the n
	 * @return true, if successful
	 */
	private static boolean inbound(int row, int col, int n) {
		if (row < 0 || row >= n || col < 0 || col >= n) {
			return false;
		}
		return true;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int n = 6;
		List<List<String>> sol = solveNQueens(n);
		System.out.println(sol.size());
	}

}
