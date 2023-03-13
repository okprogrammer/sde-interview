package graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindNumOfProvinces {
	static void dfs(int node, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
		vis[node] = true;
		for (int i : list.get(node)) {
			if (!vis[i]) {
				dfs(i, list, vis);
			}
		}
	}

	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
		// code here
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				if (adj.get(i).get(j) == 1 && i != j) {
					adjList.get(i).add(j);
					adjList.get(j).add(i);
				}
			}
		}
		boolean[] vis = new boolean[V];
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				count++;
				dfs(i, adjList, vis);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
	}
}
