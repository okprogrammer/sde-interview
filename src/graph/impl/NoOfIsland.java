package graph.impl;

import java.util.LinkedList;
import java.util.Queue;


public class NoOfIsland {

	// leetcode - we are considering only vertical and horizontal edges that are
	// forming island
	public static void bfs(int row, int col, int[][] vis, char[][] grid, int n, int m) {
		vis[row][col] = 1;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(row, col));
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int ro = p.first;
			int co = p.second;
			// traverse in the neighbours and mark then if its a land
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (Math.abs(i) == Math.abs(j)) {
						continue;
					}
					int nrow = ro + i;
					int ncol = co + j;
					if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0
							&& grid[nrow][ncol] == '1') {
						vis[nrow][ncol] = 1;
						q.add(new Pair(nrow, ncol));

					}
				}
			}
		}
	}

	public static int numIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] vis = new int[n][m];
		int cnt = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (vis[row][col] == 0 && grid[row][col] == '1') {
					cnt++;
					bfs(row, col, vis, grid, n, m);
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		char[][] grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		int numIslands = numIslands(grid);
		System.out.println(numIslands);

	}

}
