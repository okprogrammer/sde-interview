package string.impl;

public class FindFirstOccurence {
	// Input: haystack = "sadbutsad", needle = "sad"
	// Output: 0
	// Explanation: "sad" occurs at index 0 and 6.
	// The first occurrence is at index 0, so we return 0.
	public static int strStr(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		if (n < m) {
			return -1;
		}
		for (int i = 0; i < n; i++) {
			int j = i;
			int x = 0;
			while (x < m && j < n && haystack.charAt(j) == needle.charAt(x)) {
				j++;
				x++;
			}
			if (x == m) {
				return i;
			}
		}
		return -1;
	}
	


	public static void main(String[] args) {
		int ans = strStr("sadbutsad", "sad");
		System.out.println(ans);

	}

}
