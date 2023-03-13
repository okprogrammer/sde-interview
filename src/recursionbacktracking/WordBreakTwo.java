package recursionbacktracking;

import java.util.ArrayList;

/**
 * The Class WordBreakTwo.
 */
public class WordBreakTwo {

	/**
	 * Word break.
	 *
	 * @param s          the s
	 * @param dictionary the dictionary
	 * @return the array list
	 */
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		ArrayList<String> ans = new ArrayList<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (dictionary.contains(s.subSequence(0, i + 1))) {
				solve(s, s.substring(0, i + 1), dictionary, ans, i + 1, n);
			}
		}
		return ans;
	}

	/**
	 * Solve.
	 *
	 * @param s           the s
	 * @param resultSoFar the result so far
	 * @param dictionary  the dictionary
	 * @param ans         the ans
	 * @param index       the index
	 * @param n           the n
	 */
	private static void solve(String s, String resultSoFar, ArrayList<String> dictionary, ArrayList<String> ans,
			int index, int n) {
		if (index == n) {
			ans.add(resultSoFar);
			return;
		}
		resultSoFar += " ";
		for (int i = index; i < n; i++) {
			if (dictionary.contains(s.substring(index, i + 1))) {
				solve(s, resultSoFar + s.substring(index, i + 1), dictionary, ans, i + 1, n);
			}
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("god");
		list.add("is");
		list.add("now");
		list.add("no");
		list.add("where");
		list.add("here");
		ArrayList<String> ans = wordBreak("godisnowherenowhere", list);
		for (String string : ans) {
			System.out.println(string);
		}
	}
}
