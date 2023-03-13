package string.impl;

public class CountAndSayProblem {

	public static String countAndSay(int n) {
		String val = "1";
		for (int i = 0; i < n - 1; i++) {
			StringBuilder s = new StringBuilder();
			char c = val.charAt(0);
			int count = 1;
			int len = val.length();
			for (int j = 1; j < len; j++) {
				if (c != val.charAt(j)) {
					s.append(count).append(c);
					count = 0;
					c = val.charAt(j);
				}
				count++;
			}
			s.append(count).append(c);
			val = s.toString();
		}
		return val;
	}

	public static void main(String[] args) {
		String ans = countAndSay(4);
		System.out.println(ans);
	}

}
