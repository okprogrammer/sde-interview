package graph.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteInLeetCode {

	public static boolean check(int start, int[][] graph, int[] fill) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		fill[start] = 0;
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			for (int i : graph[node]) {
				if (fill[i] == -1) {
					fill[i] = 1 - fill[node];
					q.add(i);
				} else if (fill[i] == fill[node]) {
					return false;
				}
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
				if (!check(i, graph, fill)) {
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
