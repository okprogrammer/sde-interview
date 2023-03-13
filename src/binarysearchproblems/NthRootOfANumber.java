package binarysearchproblems;

public class NthRootOfANumber {
	public static double findNthRootOfM(int n, int m) {
		return binarySearchHelper(n, m, 1, m);
	}

	private static double binarySearchHelper(int n, int m, double start, double end) {
		double mid = (start + end) / 2.0;
		double min = 1e-7;
		double ans = getMul(mid, n);
		if ((end - start) < min) {
			return mid;
		} else if (ans > m) {
			return binarySearchHelper(n, m, start, mid);
		} else if (ans < m) {
			return binarySearchHelper(n, m, mid, end);
		}
		return mid;
	}

	private static double getMul(double mid, int n) {
		double ans = 1.0;
		for (int i = 1; i <= n; i++) {
			ans *= mid;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(findNthRootOfM(4, 65));
	}
}
