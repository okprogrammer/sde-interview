package graph.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUsingBFSGraph {

	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[V];
		// fill array with false to make unvisited.
		Arrays.fill(vis, false);
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				if (checkCycle(i, adj, vis)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
		vis[src] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src, -1));
		while (!q.isEmpty()) {
			int node = q.peek().first;
			int parent = q.peek().second;
			q.remove();
			for (int adjacentNode : adj.get(node)) {
				if (!vis[adjacentNode]) {
					vis[adjacentNode] = true;
					q.add(new Pair(adjacentNode, node));
				} else if (parent != adjacentNode) {
					return true;
				}
			}

		}
		return false;
	}

	public static void main(String[] args) {
		int[][] adj = { { 1 }, { 0, 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int[] arr : adj) {
			ArrayList<Integer> l = new ArrayList<>();
			for (int i : arr) {
				l.add(i);
			}
			list.add(l);
		}
		boolean cycle = isCycle(5, list);
		System.out.println(cycle);
	}

}
