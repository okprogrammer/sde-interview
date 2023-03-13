package string.impl;

public class StringToInteger {
	static int myAtoi(String s) {
		if (s == null || s.length() < 1) {
			return 0;
		}
		s = s.trim();
		char flag = '+';
		int i = 0;
		if (s.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (s.charAt(0) == '+') {
			i++;
		}
		double ans = 0;
		int n = s.length();
		while (n > i && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			ans = ans * 10 + (s.charAt(i) - '0');
			i++;
		}
		if (flag == '-') {
			ans = -ans;
		}

		// handle max and min
		if (ans < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if (ans > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) ans;
	}

	public static void main(String[] args) {
		int myAtoi = myAtoi("-9899");
		System.out.println(myAtoi);
	}
}
