package graph.impl;

import java.util.LinkedList;
import java.util.Queue;

class Trie {
	public int x;
	public int y;
	public int num;

	public Trie(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class MinTimeReqForRottingOranges {

	public static int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int countFresh = 0;
		int time = 0;
		Queue<Trie> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					visited[i][j] = true;
					q.add(new Trie(i, j, 0));
				} else if (grid[i][j] == 1) {
					countFresh++;
				}
			}
		}
		int[] dRows = { 0, 1, -1, 0 };
		int[] dCols = { 1, 0, 0, -1 };
		while (!q.isEmpty()) {
			Trie p = q.poll();
			int x = p.x;
			int y = p.y;
			int num = p.num;
			for (int i = 0; i < 4; i++) {
				int nRows = x + dRows[i];
				int nCols = y + dCols[i];
				if (nRows >= 0 && nRows < m && nCols >= 0 && nCols < n && grid[nRows][nCols] == 1
						&& !visited[nRows][nCols]) {
					visited[nRows][nCols] = true;
					q.add(new Trie(nRows, nCols, num + 1));
					countFresh--;
				}
			}
			time = num;
		}
		if (countFresh != 0) {
			return -1;
		}
		return time;
	}

	public static void main(String[] args) {

		int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

		int ans = orangesRotting(grid);
		System.out.println(ans);

	}

}
