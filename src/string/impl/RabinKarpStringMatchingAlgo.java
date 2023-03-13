package string.impl;

public class RabinKarpStringMatchingAlgo {

	// size of the alphabet
	private static int d = 26;

	// prime number for the modulo (%) operator
	private static int q = 31;

	public static int strStrRabinKarp(String haystack, String needle) {
		int textLength = haystack.length();
		int patternLength = needle.length();

		// hashes for the region of text and the pattern
		int hashText = 0;
		int hashPattern = 0;
		// the largest polynomial term in the fingerprint function
		int h = 1;

		// largest polynomial term
		for (int i = 0; i < patternLength - 1; i++) {
			h = (h * d) % q;
		}

		// pre-compute the hash of the pattern O(M)
		for (int i = 0; i < patternLength; i++) {
			hashPattern = (d * hashPattern + needle.charAt(i)) % q;
			hashText = (d * hashText + haystack.charAt(i)) % q;
		}
		for (int i = 0; i <= textLength - patternLength; i++) {
			if (hashPattern == hashText) {
				int j = 0;
				for (j = 0; j < patternLength; j++) {
					if (needle.charAt(j) != haystack.charAt(i + j)) {
						break;
					}
				}
				if (j == patternLength) {
					return i;
				}
			}
			if (i < (textLength - patternLength)) {
				hashText = ((hashText - haystack.charAt(i) * h) * d + haystack.charAt(i + patternLength)) % q;
				// to make hash +ve
				// we have added q because after taking modulo it will be less than or equal to
				// q
				if (hashText < 0) {
					hashText += q;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String hayStack = "THIS IS A TEXT";
		String needle = "TEXT";
		int ans = strStrRabinKarp(hayStack, needle);
		System.out.println(ans);
	}

}
