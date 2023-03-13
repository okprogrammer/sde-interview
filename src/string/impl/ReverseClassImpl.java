package string.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseClassImpl {

	// 1st method
	static String reverseWords(String s) {
		String ans = "";
		int n = s.length();
		String temp = "";
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == ' ') {
				if (i > 0 && s.charAt(i - 1) == ' ') {
					continue;
				}
				ans = temp + s.charAt(i) + ans;
				temp = "";
			} else {
				temp += s.charAt(i);
			}

		}
		ans = temp + " " + ans;
		return ans.trim();
	}

	// 2nd method - efficient
	static String reverseString(String s) {
		String[] split = s.split(" ");
		List<String> list = Arrays.asList(split);
		Collections.reverse(list);
		List<String> collect = list.stream().map(String::trim).filter(e -> e.length() >= 1)
				.collect(Collectors.toList());
		return String.join(" ", collect).trim();
	}

	// 3rd method - efficient
	static String reverseWordsMethod(String s) {
		char[] sArray = s.toCharArray();
		int start = 0;
		int end = sArray.length - 1;
		for (int i = 0; i <= end; i++) {
			if (sArray[i] == ' ' && (i - start) >= 1) {
				reverse(sArray, start, i - 1);
				start = i + 1;
			}
		}
		// reverse last word
		reverse(sArray, start, end);
		// reverse whole string
		reverse(sArray, 0, end);
		StringBuilder st = new StringBuilder();
		for (char c : sArray) {
			if (c != ' ') {
				st.append(c);
			} else {
				if (st.length() > 1 && Character.isWhitespace(c) && st.charAt(st.length() - 1) == ' ') {
					continue;
				} else {
					st.append(c);
				}
			}
		}
		return st.toString().trim();
	}

	private static void reverse(char[] sArray, int start, int end) {
		while (start <= end) {
			swap(sArray, start, end);
			start++;
			end--;
		}

	}

	private static void swap(char[] sArray, int start, int end) {
		char temp = sArray[start];
		sArray[start] = sArray[end];
		sArray[end] = temp;
	}

	public static void main(String[] args) {
		System.out.println(reverseWordsMethod("a good   example"));
	}

}
