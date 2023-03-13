package graph.impl;

import java.util.LinkedList;
import java.util.Queue;

public class Nearest1 {

	public static int[][] nearest(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] arr = new int[m][n];
		boolean[][] vis = new boolean[m][n];
		Queue<Tuple> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					q.add(new Tuple(i, j, 0));
					vis[i][j] = true;
					arr[i][j] = 0;
				}
			}
		}
		int[] X = { 0, 1, -1, 0 };
		int[] Y = { 1, 0, 0, -1 };
		while (!q.isEmpty()) {
			int first = q.peek().first;
			int second = q.peek().second;
			int dist = q.peek().dist;
			q.remove();
			arr[first][second] = dist;
			for (int i = 0; i < 4; i++) {
				int x = first + X[i];
				int y = second + Y[i];
				if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
					q.add(new Tuple(x, y, dist + 1));
					arr[x][y] = dist + 1;
					vis[x][y] = true;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };
		int[][] nearest = nearest(grid);
		for(int[] arr:nearest) {
			for(int i:arr) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}

}
