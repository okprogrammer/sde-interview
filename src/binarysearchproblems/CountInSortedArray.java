package binarysearchproblems;

public class CountInSortedArray {

	static int countValueInSortedArray(int[] nums, int target) {
		int firstIndex = Occurences.findFirstOccurence(nums, target);
		int lastIndex = Occurences.findLastOccurence(nums, target);
		return lastIndex - firstIndex + 1;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 2, 4, 10, 10, 10, 18, 20 };
		int ans = countValueInSortedArray(input, 10);
		System.out.println(ans);
	}

}
