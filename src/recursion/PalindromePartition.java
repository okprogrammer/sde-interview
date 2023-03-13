package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromePartition {
	static List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<>();
		List<String> helper = new ArrayList<>();
		partition(s, 0, helper, ans);
		return ans;
	}

	static void partition(String s, int index, List<String> helper, List<List<String>> ans) {
		if (index == s.length()) {
			ans.add(helper.stream().collect(Collectors.toList()));
			return;
		}
		for (int i = index; i < s.length(); ++i) {
			String partString = s.substring(index, i + 1);
			if (isPalindrome(partString)) {
				helper.add(partString);
				partition(s, i + 1, helper, ans);
				helper.remove(helper.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String partString) {
		int start = 0;
		int end = partString.length() - 1;
		while (start <= end) {
			if (partString.charAt(start) != partString.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "aab";
		List<List<String>> partition = partition(input);
		for (List<String> list : partition) {
			System.out.println(list.toString());
		}
	}

}
