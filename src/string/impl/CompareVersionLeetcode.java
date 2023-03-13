package string.impl;

import java.util.ArrayList;

public class CompareVersionLeetcode {

	public static int compareVersion(String version1, String version2) {
		String[] str1 = version1.split("[.]");
		String[] str2 = version2.split("[.]");
		ArrayList<String> s1 = new ArrayList<>();
		ArrayList<String> s2 = new ArrayList<>();
		for (String s : str1) {
			s1.add(s);
		}
		for (String s : str2) {
			s2.add(s);
		}
		int m = s1.size();
		int n = s2.size();
		int diff = Math.abs(m - n);
		if (m > n) {
			for (int i = 0; i < diff; i++) {
				s2.add("0");
			}
		} else {
			for (int i = 0; i < diff; i++) {
				s1.add("0");
			}
		}
		int len = s1.size();
		for (int i = 0; i < len; i++) {
			int a = Integer.parseInt(s1.get(i));
			int b = Integer.parseInt(s2.get(i));
			if (a > b) {
				return 1;
			} else if (b > a) {
				return -1;
			}
		}
		return 0;
	}

	public static int compareVersion1(String version1, String version2) {
		int i = 0, j = 0, v1 = version1.length(), v2 = version2.length(), n1, n2;
		while (i < v1 || j < v2) {
			n1 = 0;
			n2 = 0;
			while (i < v1 && version1.charAt(i) != '.') {
				n1 = n1 * 10 + (version1.charAt(i) - '0');
				i++;
			}
			while (j < v2 && version2.charAt(j) != '.') {
				n2 = n2 * 10 + (version2.charAt(j) - '0');
				j++;
			}
			if (n1 > n2) {
				return 1;
			} else if (n1 < n2) {
				return -1;
			}
			i++;
			j++;
		}
		return 0;
	}

	public static void main(String[] args) {
		String s1 = "1.01";
		String s2 = "1.001";
		int ans = compareVersion1(s1, s2);
		System.out.println(ans);
	}

}
