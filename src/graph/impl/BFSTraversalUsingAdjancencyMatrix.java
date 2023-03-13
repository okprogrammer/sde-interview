package graph.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversalUsingAdjancencyMatrix {

	public static void main(String[] args) {

	}

	static ArrayList<Integer> bfsOfGraphUsingAdjancencyMatrix(int vertex, int[][] edges) {
		ArrayList<Integer> result = new ArrayList<>();
		int[][] adjacency_matrix = createAdjMat(vertex, edges);
		boolean visited[] = new boolean[adjacency_matrix.length];

		// Traversing through all the nodes.
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				printBFSHelper(adjacency_matrix, i, visited, result);
			}
		}

		return result;
	}

	// Converts the given input into adjacency matrix.
	public static int[][] createAdjMat(int vertex, int[][] edges) {

		int adjacency_matrix[][] = new int[vertex][vertex];

		for (int i = 0; i < edges[0].length; i++) {
			adjacency_matrix[edges[0][i]][edges[1][i]] = 1;
			adjacency_matrix[edges[1][i]][edges[0][i]] = 1;
		}

		return adjacency_matrix;
	}

	public static void printBFSHelper(int edges[][], int source, boolean visited[], ArrayList<Integer> result) {
		Queue<Integer> queue = new LinkedList<>();
		visited[source] = true;
		queue.add(source);
		// Traversing all the nodes that are connected to the source node.
		while (!queue.isEmpty()) {
			int front = queue.remove();
			result.add(front);
			for (int i = 0; i < edges.length; i++) {
				if (edges[front][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
