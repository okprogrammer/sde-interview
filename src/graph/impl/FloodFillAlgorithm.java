package graph.impl;

import java.util.Iterator;

public class FloodFillAlgorithm {

	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int[][] tempImg = image;
		int n = image.length;
		int m = image[0].length;
		int[] delX = new int[] { 1, 0, -1, 0 };
		int[] delY = new int[] { 0, 1, 0, -1 };
		int initialColor = image[sr][sc];
		dfs(tempImg, delX, delY, sr, sc, color, initialColor, n, m);
		return tempImg;
	}

	private static void dfs(int[][] image, int[] delX, int[] delY, int sr, int sc, int color, int initialColor, int n,
			int m) {
		image[sr][sc] = color;
		for (int i = 0; i < 4; i++) {
			int X = delX[i] + sr;
			int Y = delY[i] + sc;
			if (X >= 0 && X < n && Y >= 0 && Y < m && image[X][Y] == initialColor && image[X][Y] != color) {
				dfs(image, delX, delY, X, Y, color, initialColor, n, m);
			}
		}

	}

	public static void main(String[] args) {
		int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int[][] floodFill = floodFill(image, 1, 1, 2);
		for (int i = 0; i < floodFill.length; i++) {
			for (int j = 0; j < floodFill[i].length; j++) {
				System.out.print(floodFill[i][j]+" ");
			}
			System.out.println();
		}
	}

}
