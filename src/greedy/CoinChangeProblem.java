package greedy;

import java.util.*;

public class CoinChangeProblem {

	static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int count = 0;
		if (amount == 0) {
			return count;
		}
		if (coins.length == 1) {
			while (amount > 0) {
				amount = amount - coins[0];
				count++;
			}
		}
		if (amount < 0) {
			return -1;
		} else if (amount == 0) {
			return count;
		}
		int i = -1;
		while (amount != 0) {
			int index = Arrays.binarySearch(coins, amount);
			i = index < 0 ? Math.abs(index + 2) : index;
			amount = amount - coins[i];
			count++;
		}
		return count;
	}

	static int coinChangeAnother(int[] coins, int amount) {
		int n = coins.length;
		if (amount == 0) {
			return 0;
		}
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			while (amount >= coins[i]) {
				amount -= coins[i];
				count++;
			}
		}
		return count>10000?-1:count;
	}

	// leetcode
	static int coinChangeDP(int[] coins, int amount) {
		int m = coins.length + 1;
		int n = amount + 1;
		int[][] storage = new int[m][n];
		for (int i = 1; i < n; i++) {
			storage[0][i] = Integer.MAX_VALUE-1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (coins[i - 1] > j) {
					storage[i][j] = storage[i - 1][j];
				} else {
					storage[i][j] = Math.min(storage[i - 1][j], 1 + storage[i][j - coins[i - 1]]);
				}
			}
		}
		return storage[m - 1][n - 1] > 10000 ? -1 : storage[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[] coins = new int[] { 1, 2, 5 };
		int amount = 11;
		System.out.println(coinChangeAnother(coins, amount));
	}

}
