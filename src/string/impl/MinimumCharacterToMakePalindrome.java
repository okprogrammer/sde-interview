package string.impl;

public class MinimumCharacterToMakePalindrome {

	// TIME LIMIT EXCEEDED
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public int minCharacterToMakePalindrom(String A) {
		String s = A;
		int count = 0;
		while (s.length() > 0) {
			if (isPalindrome(s)) {
				break;
			} else {
				count++;
				s = s.substring(0, s.length() - 1);
			}
		}

		return count;
	}

	// 2nd method using LSP array.
	public static int minToMakePal(String A) {
		StringBuilder s = new StringBuilder(A);
		String reverse = s.reverse().toString();
		s.reverse().append('$').append(reverse);
		int n = s.length();
		int[] lsp = new int[n];
		computeLSP(s.toString(), lsp, n);
		int ans = A.length() - lsp[n - 1];
		return ans;
	}

	private static void computeLSP(String s, int[] lsp, int n) {
		int prefixCount = 0;
		int i = 1;
		while (i < n) {
			if (s.charAt(i) == s.charAt(prefixCount)) {
				prefixCount++;
				lsp[i] = prefixCount;
				i++;
			} else {
				if (prefixCount != 0) {
					prefixCount = lsp[prefixCount - 1];
				} else {
					lsp[i] = 0;
					i++;
				}
			}
		}

	}

	public static void main(String[] args) {
		int ans = minToMakePal("AACECAAAA");
		System.out.println(ans);
	}
}
