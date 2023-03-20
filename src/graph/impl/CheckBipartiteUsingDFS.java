package graph.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteUsingDFS {

	public static boolean dfs(int start, int color, int[][] graph, int[] fill) {
		fill[start] = color;
		for (int i : graph[start]) {
			if (fill[i] == -1) {
				return dfs(i, 1 - color, graph, fill);
			} else if (color == fill[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] fill = new int[n];
		Arrays.fill(fill, -1);
		for (int i = 0; i < n; i++) {
			if (fill[i] == -1) {
				if (!dfs(i, 0, graph, fill)) {
					return false;
				}
			}

		}
		return true;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		boolean bipartite = isBipartite(graph);
		System.out.println(bipartite);
	}

}
