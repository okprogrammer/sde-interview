package recursionbacktracking;

public class MColoringProblem {
	static boolean graphColoring(boolean graph[][], int m, int n) {
		int[] color = new int[n];
		return solve(0, graph, color, m, n);
	}

	static boolean solve(int node, boolean[][] graph, int[] color, int m, int n) {
		if(node == n) {
			return true;
		}
		for (int i = 1; i <=m; i++) {
			if(isSafe(node,graph,color,i)) {
				color[node] = i;
				if(solve(node+1, graph, color, m, n)) {
					return true;
				}
				color[node] = 0;
			}
			
		}
		return false;
	}

	private static boolean isSafe(int node, boolean[][] graph, int[] color, int i) {
		int n = color.length;
		for (int j = 0; j < n; j++) {
			if(graph[node][j] && color[j] == i) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		//{(0,1),(1,2),(2,3),(3,0),(0,2)}
		boolean[][] graph = new boolean[4][4];
		graph[0][1] = true;
		graph[1][0] = true;
		graph[1][2] = true;
		graph[2][1] = true;
		graph[2][3] = true;
		graph[3][2] = true;
		graph[3][0] = true;
		graph[0][3] = true;
		graph[0][2] = true;
		graph[2][0] = true;
		boolean ans = graphColoring(graph, 3, 4);
		System.out.println(ans);
	}
}
