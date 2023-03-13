package string.impl;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int n = s.length();
		char prev = s.charAt(0);
		int num = map.get(prev);
		int prevNum = num;
		for (int i = 1; i < n; i++) {
			char curr = s.charAt(i);
			int currVal = map.get(curr);
			if (prevNum >= currVal) {
				num = num + currVal;
			} else {
				num = num + currVal - 2 * prevNum;
			}
			prev = curr;
			prevNum = currVal;
		}
		return num;
	}

	public static void main(String[] args) {
		// 1000+900+10+4
		// String s = "MCMXCIV";
		String s = "IV";
		int ans = romanToInt(s);
		System.out.println(ans);
	}

}
