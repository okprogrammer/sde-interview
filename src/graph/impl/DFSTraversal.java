package graph.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSTraversal {

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
		List<Integer> dfsOfGraph = dfsOfGraph(N, adjList);
		for (Integer i : dfsOfGraph) {
			System.out.print(i + " ");
		}
	}

	private static List<Integer> dfsOfGraph(int V, List<List<Integer>> graph) {
		List<Integer> dfsOfGraph = new ArrayList<>();
		boolean[] vis = new boolean[V];
		dfsOfGraph(graph, dfsOfGraph, vis, 0);
		return dfsOfGraph;
	}

	private static void dfsOfGraph(List<List<Integer>> graph, List<Integer> dfsOfGraph, boolean[] vis, int node) {
		vis[node] = true;
		dfsOfGraph.add(node);
		for (int i : graph.get(node)) {
			if (!vis[i]) {
				dfsOfGraph(graph, dfsOfGraph, vis, i);
			}
		}
	}

}
