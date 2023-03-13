package string.impl;

import java.util.Arrays;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length < 1) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int n = strs.length;
		Arrays.sort(strs);
		int j = 0;
		int min = Math.min(strs[0].length(), strs[n - 1].length());
		for (int i = 0; i < min; i++) {
			if (strs[0].charAt(i) == strs[n - 1].charAt(i)) {
				j++;
			} else {
				break;
			}
		}
		return strs[0].substring(0, j);
	}

	public static void main(String[] args) {
		String[] arr = { "flower", "flow", "flight" };
		String ans = longestCommonPrefix(arr);
		System.out.println(ans);
	}
}
