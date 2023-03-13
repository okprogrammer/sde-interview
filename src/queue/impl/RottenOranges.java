package queue.impl;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;
	int num;

	public Pair(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class RottenOranges {

	public static int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int countFresh = 0;
		int time = 0;
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					visited[i][j] = true;
					q.add(new Pair(i, j, 0));
				} else if (grid[i][j] == 1) {
					countFresh++;
				}
			}
		}
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			int num = p.num;
			// for left
			if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
				visited[x - 1][y] = true;
				q.add(new Pair(x - 1, y, num + 1));
				countFresh--;
			}
			// for top
			if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
				visited[x][y - 1] = true;
				q.add(new Pair(x, y - 1, num + 1));
				countFresh--;
			}
			// for right
			if (x + 1 < m && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
				visited[x + 1][y] = true;
				q.add(new Pair(x + 1, y, num + 1));
				countFresh--;
			}

			// for bottom
			if (y + 1 < n && grid[x][y + 1] == 1 && !visited[x][y + 1]) {
				visited[x][y + 1] = true;
				q.add(new Pair(x, y + 1, num + 1));
				countFresh--;
			}
			time = num;
		}
		if (countFresh != 0) {
			return -1;
		}
		return time;
	}

	public static void main(String[] args) {
		int[][] nums = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int[][] nums1 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		int ans = orangesRotting(nums1);
		System.out.println(ans);
	}

}
