package dp.problem;

public class UnboundedKnapSack {

	static int knapsackRec(int[] wt, int[] val, int W, int n) {
		if (n < 0 || W == 0) {
			return 0;
		}
		if (wt[n] <= W) {
			return Math.max(val[n] + knapsackRec(wt, val, W - wt[n], n), knapsackRec(wt, val, W, n - 1));
		} else {
			return knapsackRec(wt, val, W, n - 1);
		}

	}

	static int knapsackUsingMemo(int[] wt, int[] val, int W, int n, int[][] storage) {
		if (n == 0 || W == 0) {
			return 0;
		}
		if (storage[n][W] > 0) {
			return storage[n][W];
		}
		if (wt[n - 1] <= W) {
			storage[n][W] = Math.max(val[n - 1] + knapsackUsingMemo(wt, val, W - wt[n - 1], n, storage),
					knapsackUsingMemo(wt, val, W, n - 1, storage));
			return storage[n][W];
		} else {
			storage[n][W] = knapsackUsingMemo(wt, val, W, n - 1, storage);
			return storage[n][W];
		}
	}

	static int knapsackUsingDP(int[] wt, int[] val, int W) {
		int n = val.length;
		int m = W;
		int[][] storage = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (wt[i - 1] <= j) {
					storage[i][j] = Math.max(val[i - 1] + storage[i][j - wt[i - 1]], storage[i - 1][j]);
				} else {
					storage[i][j] = storage[i - 1][j];
				}
			}
		}
		return storage[n][m];
	}

	public static void main(String[] args) {
		int[] wt = { 1, 3, 4, 5 };
		int[] val = { 1, 4, 7, 5, };
		int W = 15;
		int ans = knapsackRec(wt, val, W, wt.length - 1);
		System.out.println("Knapsack using recursion " + ans);
		System.out.println("**************************************");
		int n = wt.length;
		int[][] storage = new int[n + 1][W + 1];
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[i].length; j++) {
				storage[i][j] = -1;
			}
		}
		// Arrays.fill(storage, -1);
		int res = knapsackUsingMemo(wt, val, W, n, storage);
		System.out.println("Knapsack using memo " + res);
		System.out.println("Knapsack using DP table " + knapsackUsingDP(wt, val, W));
	}

}
