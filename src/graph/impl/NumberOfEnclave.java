package graph.impl;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclave {

	static int numberOfEnclaves(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] vis = new boolean[m][n];
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
					if (grid[i][j] == 1) {
						q.add(new Pair(i, j));
						vis[i][j] = true;
					}
				}
			}
		}
		int[] X = { 0, 1, 0, -1 };
		int[] Y = { 1, 0, -1, 0 };
		while (!q.isEmpty()) {
			int first = q.peek().first;
			int second = q.peek().second;
			q.remove();
			for (int i = 0; i < 4; i++) {
				int x = first + X[i];
				int y = second + Y[i];
				if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 1) {
					q.add(new Pair(x, y));
					vis[x][y] = true;
					// count++;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!vis[i][j] && grid[i][j] == 1) {
					count++;
					vis[i][j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int numberOfEnclaves = numberOfEnclaves(grid);
		System.out.println(numberOfEnclaves);

	}

}
