package practice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyWays {

	public static String[] permutation(String input) {
		if (input.length() == 1) {
			return new String[] { "" + input.charAt(0) };
		}
		String[] smallAns = permutation(input.substring(1));
		String[] result = new String[smallAns.length * (smallAns[0].length() + 1)];
		int k = 0;
		for (int i = 0; i < smallAns.length; i++) {
			String word = smallAns[i];
			for (int j = 0; j <= word.length(); j++) {
				result[k++] = word.substring(0, j) + input.charAt(0) + word.substring(j);
			}
		}
		return result;
	}

	static void getSumToK(int[] input, int k) {
		boolean flag = false;
		int n = input.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = input[i] + input[j];
				if (sum == k) {
					if (!flag) {
						System.out.print("{" + input[i] + "," + input[j] + "}");
					} else {
						System.out.print("," + "{" + input[i] + "," + input[j] + "}");
					}
					flag = true;
				}
			}
		}
	}

	public static void main(String[] args) {
//		String input = "abc";
//		// System.out.println(input.substring(0));
//		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9 };
//		getSumToK(arr, 6);
//		String[] ans = permutation(input);
//		for (int i = 0; i < ans.length; i++) {
//			System.out.println(ans[i]);
//		}
		//DateTimeFormatter
		
	}

}
