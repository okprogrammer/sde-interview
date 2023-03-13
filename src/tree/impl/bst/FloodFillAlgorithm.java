package tree.impl.bst;

public class FloodFillAlgorithm {
	public void dfs(int[][] image, int[][] res, int row, int col, int newColor, int iniColor, int[] delRow,
			int[] delCol) {
		res[row][col] = newColor;
		for (int i = 0; i < 4; i++) {
			int nRow = row + delRow[i];
			int nCol = col + delCol[i];
			int n = image.length;
			int m = image[0].length;
			if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == iniColor
					&& image[nRow][nCol] != newColor) {
				dfs(image, res, nRow, nCol, newColor, iniColor, delRow, delCol);
			}
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int[][] res = image;
		int iniColor = image[sr][sc];
		int[] delRow = new int[] { -1, 0, 1, 0 };
		int[] delCol = new int[] { 0, 1, 0, -1 };
		dfs(image, res, sr, sc, color, iniColor, delRow, delCol);
		return res;
	}

	public static void main(String[] args) {

	}

}
