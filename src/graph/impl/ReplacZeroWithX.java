package graph.impl;

//https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1
public class ReplacZeroWithX {

	static void dfs(char[][] a, int i, int j, int[] delX, int[] delY, boolean[][] vis, int n, int m) {
		vis[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int x = i + delX[k];
			int y = j + delY[k];
			if (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && a[x][y] == 'O') {
				dfs(a, x, y, delX, delY, vis, n, m);
			}
		}
	}

	static char[][] fill(int n, int m, char a[][]) {
		boolean[][] vis = new boolean[n][m];
		int[] delX = { 0, 1, 0, -1 };
		int[] delY = { 1, 0, -1, 0 };
		// traverse first and last row
		for (int i = 0; i < m; i++) {
			if (!vis[0][i] && a[0][i] == 'O') {
				// traverse and adjacent node and mark them visited if containing zero
				dfs(a, 0, i, delX, delY, vis, n, m);
			}
			if (!vis[n - 1][i] && a[n - 1][i] == 'O') {
				// traverse and adjacent node and mark them visited if containing zero
				dfs(a, n - 1, i, delX, delY, vis, n, m);
			}
		}
		// traverse first and last column
		for (int i = 0; i < n; i++) {
			if (!vis[i][0] && a[i][0] == 'O') {
				// traverse and adjacent node and mark them visited if containing zero
				dfs(a, i, 0, delX, delY, vis, n, m);
			}
			if (!vis[i][m - 1] && a[i][m - 1] == 'O') {
				// traverse and adjacent node and mark them visited if containing zero
				dfs(a, i, m - 1, delX, delY, vis, n, m);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 'O' && !vis[i][j]) {
					a[i][j] = 'X';
				}
			}
		}
		return a;

	}

	public static void main(String[] args) {

	}

}
