package arr_part3;

public class CountUniquePath {

	static int uniquePaths(int m, int n) {
		return uniquePaths(m, n, 0, 0);
	}

	static int uniquePathsMemo(int m, int n, int[][] storage) {
		return uniquePathsMemo(m, n, 0, 0, storage);
	}

	private static int uniquePaths(int m, int n, int i, int j) {
		if (i == m - 1 && j == n - 1) {
			return 1;
		} else if (i >= m || j >= n) {
			return 0;
		} else {
			int op1 = uniquePaths(m, n, i + 1, j);
			int op2 = uniquePaths(m, n, i, j + 1);
			return op1 + op2;
		}
	}

	private static int uniquePathsMemo(int m, int n, int i, int j, int[][] storage) {
		if (i == m - 1 && j == n - 1) {
			return 1;
		} else if (i >= m || j >= n) {
			return 0;
		} else if (storage[i][j] != -1) {
			return storage[i][j];
		} else {
			int op1 = uniquePathsMemo(m, n, i + 1, j, storage);
			int op2 = uniquePathsMemo(m, n, i, j + 1, storage);
			storage[i][j] = op1 + op2;
			return storage[i][j];
		}
		// return storage[m - 1][n - 1];
	}

	private static int uniquePathsComb(int m, int n) {
		int totalStep = m + n - 2;
		double res = 1;
		int r = m - 1;
		for (int i = 1; i <= r; i++) {
			res = res * (totalStep - r + i) / i;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 3));
		int[][] storage = new int[2][3];
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[i].length; j++) {
				storage[i][j] = -1;
			}
		}

		System.out.println(uniquePathsMemo(2, 3, storage));
		System.out.println(uniquePathsComb(3,2));
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[i].length; j++) {
				System.out.print(storage[i][j] + " ");
			}
			System.out.println();
		}

	}

}
