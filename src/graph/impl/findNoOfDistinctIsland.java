package graph.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findNoOfDistinctIsland {

	private static String toString(int i, int j) {
		return Integer.toString(i) + " " + Integer.toString(j);
	}

	static int countDistinctIslands(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] vis = new boolean[m][n];
		Set<List<String>> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				List<String> list = new ArrayList<>();
				if (!vis[i][j] && grid[i][j] == 1) {
					dfs(i, j, grid, vis, m, n, list, i, j);
					set.add(list);
				}
			}
		}
		return set.size();
	}

	private static void dfs(int row, int col, int[][] grid, boolean[][] vis, int m, int n, List<String> list, int row0,
			int col0) {
		vis[row][col] = true;
		list.add(toString(row - row0, col - col0));
		int[] X = { 1, 0, -1, 0 };
		int[] Y = { 0, 1, 0, -1 };
		for (int i = 0; i < 4; i++) {
			int iRow = row + X[i];
			int iCol = col + Y[i];
			if (iRow >= 0 && iRow < m && iCol >= 0 && iCol < n && !vis[iRow][iCol] && grid[iRow][iCol] == 1) {
				dfs(iRow, iCol, grid, vis, m, n, list, row0, col0);
			}
		}

	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		int islands = countDistinctIslands(grid);
		System.out.println(islands);
		

	}

}
