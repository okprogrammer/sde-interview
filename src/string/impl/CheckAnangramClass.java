package string.impl;

public class CheckAnangramClass {

	public static boolean isAnagram(String s, String t) {
		int[] freq = new int[256];
		int n = s.length();
		int m = t.length();
		if (m != n) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			freq[s.charAt(i)]++;
			freq[t.charAt(i)]--;
		}
		for (int i = 0; i < 256; i++) {
			if (freq[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
