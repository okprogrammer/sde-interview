package graph.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUsingDFSGraph {

	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[V];
		// fill array with false to make unvisited.
		Arrays.fill(vis, false);
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				if (checkCycle(i, -1, adj, vis)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
		vis[node] = true;
		for (int adjacentNode : adj.get(node)) {
			if (!vis[adjacentNode]) {
				if (checkCycle(adjacentNode, node, adj, vis)) {
					return true;
				}
			} else if (parent != adjacentNode) {
				return true;
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
