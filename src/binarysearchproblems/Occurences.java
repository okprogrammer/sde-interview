package binarysearchproblems;

public class Occurences {

	static int findFirstOccurence(int[] input, int target) {
		int start = 0;
		int end = input.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (input[mid] == target) {
				ans = mid;
				end = mid - 1;
			} else if (input[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	static int findLastOccurence(int[] input, int target) {
		int start = 0;
		int end = input.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (input[mid] == target) {
				ans = mid;
				start = mid + 1;
			} else if (input[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 2, 4, 10, 10, 10, 18, 20 };
		int findFirstOccurence = findLastOccurence(input, 10);
		System.out.println(findFirstOccurence);
	}

}
