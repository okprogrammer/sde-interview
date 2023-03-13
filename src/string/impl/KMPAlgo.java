package string.impl;

public class KMPAlgo {

	static int KMPAlgoStringMatching(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int[] arr = new int[m];
		if (n < m) {
			return -1;
		}
		constructTable(pattern, arr, m);
		int j = 0;
		int i = 0;
		while (i < n) {
			if (j < m && text.charAt(i) == pattern.charAt(j)) {
				j++;
				i++;
			}
			if (j == m) {
				return (i - j);
			}
			if (i < n && j < n && text.charAt(i) != pattern.charAt(j)) {
				if (j != 0) {
					j = arr[j - 1];
				} else {
					i++;
				}

			}
		}
		return -1;
	}

	private static void constructTable(String pattern, int[] arr, int m) {
		int prefixCount = 0;
		int i = 1;
		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(prefixCount)) {
				prefixCount++;
				arr[i] = prefixCount;
				i++;
			} else {
				if (prefixCount != 0) {
					prefixCount = arr[prefixCount - 1];
				} else {
					arr[i] = 0;
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// [0, 1, 1, 1, 1]
		String hayStack = "mississippi";
		String needle = "issip";
		int ans = KMPAlgoStringMatching(hayStack, needle);
		System.out.println(ans);
	}

}
