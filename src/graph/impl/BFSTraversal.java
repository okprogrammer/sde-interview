package graph.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {

	public static void main(String[] args) {
		int N = 9;
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		// String s = "Hello";
		adjList.get(0).addAll(List.of(1, 5));
		adjList.get(1).addAll(List.of(0, 2, 3));
		adjList.get(2).addAll(List.of(1));
		adjList.get(3).addAll(List.of(1, 4));
		adjList.get(4).addAll(List.of(3, 7));
		adjList.get(5).addAll(List.of(0, 6, 8));
		adjList.get(6).addAll(List.of(5, 7));
		adjList.get(7).addAll(List.of(6, 4));
		adjList.get(8).addAll(List.of(5));
		List<Integer> bfsOfGraph = bfsOfGraph(N, adjList);
		for (Integer i : bfsOfGraph) {
			System.out.print(i + " ");
		}
	}

	private static List<Integer> bfsOfGraph(int V, List<List<Integer>> graph) {
		List<Integer> bfsTraversal = new ArrayList<>();
		boolean[] vis = new boolean[V + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		vis[0] = true;
		while (!q.isEmpty()) {
			Integer node = q.poll();
			bfsTraversal.add(node);
			for (int i : graph.get(node)) {
				if (!vis[i]) {
					vis[i] = true;
					q.add(i);
				}
			}
		}
		return bfsTraversal;
	}

}
