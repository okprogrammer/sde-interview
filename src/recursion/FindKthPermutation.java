package recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The Class FindKthPermutation.
 */
public class FindKthPermutation {

	/**
	 * Gets the permutation.
	 *
	 * @param n the n
	 * @param k the k
	 * @return the permutation
	 */
	static String getPermutation(int n, int k) {
		String input = "";
		for (int i = 1; i <= n; i++) {
			input = input + i;
		}
		List<String> list = new ArrayList<>();
		System.out.println(input.length());
		getPermutation(input, "", list, n);
		return list.get(k - 1);
	}

	/**
	 * Gets the permutation.
	 *
	 * @param input       the input
	 * @param resultSoFar the result so far
	 * @param list        the list
	 * @param n           the n
	 * @return the permutation
	 */
	static void getPermutation(String input, String resultSoFar, List<String> list, int n) {
		if (resultSoFar.length() == n) {
			list.add(resultSoFar);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			getPermutation(input.substring(0, i) + input.substring(i + 1), resultSoFar + input.charAt(i), list, n);
		}
	}

	/**
	 * Gets the permuation of string.
	 *
	 * @param input the input
	 * @return the permuation of string
	 */
	static String[] getPermuationOfString(String input) {
		if (input.length() == 1) {
			return new String[] { input.charAt(0) + "" };
		}
		String[] smallAns = getPermuationOfString(input.substring(1));
		String[] result = new String[(smallAns[0].length() + 1) * smallAns.length];
		int k = 0;
		for (int i = 0; i < smallAns.length; i++) {
			String word = smallAns[i];
			for (int j = 0; j <= word.length(); j++) {
				result[k++] = word.substring(0, j) + input.charAt(0) + word.substring(j);
			}
		}
		return result;
	}

	static void getPermutationAnotherApproach(char[] input, int index, List<String> res) {
		if (index == input.length) {
			String ans = new String(input);
			res.add(ans);
			return;
		}
		for (int i = index; i < input.length; i++) {
			swap(input, i, index);
			getPermutationAnotherApproach(input, index + 1, res);
			swap(input, i, index);
		}
	}

	static String getPermuationAnother(int n, int k) {
		String input = "";
		for (int i = 1; i <= n; i++) {
			input = input + i;
		}
		List<String> list = new ArrayList<>();
		getPermutationAnotherApproach(input.toCharArray(), 0, list);
		Collections.sort(list);
		return list.get(k - 1);
	}

	private static void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	static String getPermutations2(int n, int k) {
		List<Integer> list = new ArrayList<>();
		int fact = 1;
		for (int i = 1; i < n; i++) {
			list.add(i);
			fact = fact * i;
		}
		list.add(n);
		k = k - 1;
		String ans = "";
		while (true) {
			int index = k / fact;
			ans = ans + list.get(index);
			list.remove(index);
			if (list.size() == 0) {
				break;
			}
			k = k % fact;
			fact = fact / list.size();
		}
		return ans;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String permutation = getPermutations2(4, 9);
		System.out.println(permutation);
		String input = "";
//		for (int i = 1; i <= 3; i++) {
//			input = input.concat(i + "");
//		}
//		String[] ans = getPermuationOfString(input);
//		Arrays.sort(ans);
//		for (int i = 0; i < ans.length; i++) {
//			System.out.println(ans[i]);
//		}
	}

}
