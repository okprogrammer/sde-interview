package recursionbacktracking;

import java.util.ArrayList;

/**
 * The Class RatInMaze.
 */
public class RatInMaze {

	/**
	 * Find path 1.
	 *
	 * @param m the m
	 * @param n the n
	 * @return the array list
	 */
	// 2nd Approach
	public static ArrayList<String> findPath1(int[][] m, int n) {
		if (m[n - 1][n - 1] != 1 || m[0][0] != 1 || n == 0) {
			return new ArrayList<>();
		}
		ArrayList<String> ans = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		int[] di = new int[] { 1, 0, -1, 0 };
		int[] dj = new int[] { 0, 1, 0, -1 };
		String dir = "DRUL";
		solve1(m, 0, 0, n, ans, "", visited, di, dj, dir);
		return ans;
	}

	/**
	 * Solve 1.
	 *
	 * @param m           the m
	 * @param i           the i
	 * @param j           the j
	 * @param n           the n
	 * @param ans         the ans
	 * @param resultSoFar the result so far
	 * @param visited     the visited
	 * @param di          the di
	 * @param dj          the dj
	 * @param dir         the dir
	 */
	private static void solve1(int[][] m, int i, int j, int n, ArrayList<String> ans, String resultSoFar,
			boolean[][] visited, int[] di, int[] dj, String dir) {
		if (i == n - 1 && j == n - 1) {
			ans.add(resultSoFar);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nextI = di[k] + i;
			int nextJ = dj[k] + j;
			if (nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n && !visited[nextI][nextJ] && m[nextI][nextJ] == 1) {
				visited[i][j] = true;
				solve1(m, nextI, nextJ, n, ans, resultSoFar + dir.charAt(k), visited, di, dj, dir);
				visited[i][j] = false;
			}
		}
	}

	/**
	 * Find path.
	 *
	 * @param m the m
	 * @param n the n
	 * @return the array list
	 */
	public static ArrayList<String> findPath(int[][] m, int n) {
		if (m[n - 1][n - 1] != 1 || m[0][0] != 1 || n == 0) {
			return new ArrayList<>();
		}
		ArrayList<String> ans = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		solve(m, 0, 0, n, ans, "", visited);
		return ans;
	}

	/**
	 * Solve.
	 *
	 * @param m           the m
	 * @param i           the i
	 * @param j           the j
	 * @param n           the n
	 * @param ans         the ans
	 * @param resultSoFar the result so far
	 * @param visited     the visited
	 */
	private static void solve(int[][] m, int i, int j, int n, ArrayList<String> ans, String resultSoFar,
			boolean[][] visited) {
		if (i == n - 1 && j == n - 1) {
			ans.add(resultSoFar);
			return;
		}
		// downward
		if (i + 1 < n && m[i + 1][j] == 1 && !visited[i + 1][j]) {
			visited[i][j] = true;
			solve(m, i + 1, j, n, ans, resultSoFar + 'D', visited);
			visited[i][j] = false;
		}
		// right
		if (j + 1 < n && m[i][j + 1] == 1 && !visited[i][j + 1]) {
			visited[i][j] = true;
			solve(m, i, j + 1, n, ans, resultSoFar + 'R', visited);
			visited[i][j] = false;
		}
		// upward
		if (i - 1 >= 0 && m[i - 1][j] == 1 && !visited[i - 1][j]) {
			visited[i][j] = true;
			solve(m, i - 1, j, n, ans, resultSoFar + 'U', visited);
			visited[i][j] = false;
		}
		// left
		if (j - 1 >= 0 && m[i][j - 1] == 1 && !visited[i][j - 1]) {
			visited[i][j] = true;
			solve(m, i, j - 1, n, ans, resultSoFar + 'L', visited);
			visited[i][j] = false;
		}

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int m[][] = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };
		// int m[][] = { { 1, 0 }, { 1, 0 } };
		int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		int n = 5;
		ArrayList<String> findPath = findPath1(m, n);
		if (findPath.isEmpty()) {
			System.out.println("-1");
		}
		for (String string : findPath) {
			System.out.println(string);
		}
	}

}
