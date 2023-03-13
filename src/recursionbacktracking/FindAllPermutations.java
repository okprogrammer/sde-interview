package recursionbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllPermutations {

	static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		findPermutation(nums, 0, res);
		return res;

	}

	static void findPermutation(int[] nums, int index, List<List<Integer>> res) {
		if (index == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int i : nums) {
				list.add(i);
			}
			res.add(list);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(nums, index, i);
			findPermutation(nums, index + 1, res);
			swap(nums, index, i);
		}
	}

	static void swap(int[] nums, int index, int i) {
		int temp = nums[index];
		nums[index] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3};
		List<List<Integer>> permute = permute(arr);
		for (List<Integer> list : permute) {
			System.out.println(list.toString());
		}
	}

}
