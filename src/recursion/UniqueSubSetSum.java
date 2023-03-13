package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class UniqueSubSetSum.
 */
public class UniqueSubSetSum {
	/****************************************
	 * 1st Approach
	 *********************************/
	/**
	 * Combination sum.
	 *
	 * @param candidates the candidates
	 * @param target     the target
	 * @return the list
	 */
	static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> helper = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		combinationSum(candidates, target, 0, helper, ans, 0);
		return ans;
	}

	/**
	 * Combination sum.
	 *
	 * @param candidates the candidates
	 * @param target     the target
	 * @param i          the i
	 * @param helper     the helper
	 * @param ans        the ans
	 * @param helperSum  the helper sum
	 */
	private static void combinationSum(int[] candidates, int target, int i, List<Integer> helper,
			List<List<Integer>> ans, int helperSum) {
		List<Integer> list = List.copyOf(helper);
		if (i == candidates.length || helperSum >= target) {
			int sum = 0;
			for (int s : list) {
				sum = s + sum;
			}
			if (target == sum) {
				ans.add(0, list);
			}
			return;
		}
		helper.add(candidates[i]);
		combinationSum(candidates, target, i, helper, ans, helperSum + candidates[i]);
		helper.remove(helper.size() - 1);
		combinationSum(candidates, target, i + 1, helper, ans, helperSum);
	}

	/****************************************
	 * 2nd Approach
	 *********************************/
	static List<List<Integer>> combinationSumAnother(int[] candidates, int target) {
		List<Integer> helper = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, helper, ans);
		// return ans.stream().distinct().collect(Collectors.toList());
		return ans;
	}

	private static void combinationSum(int[] candidates, int target, int index, List<Integer> helper,
			List<List<Integer>> ans) {
		if (target == 0) {
			ans.add(List.copyOf(helper));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (i > index && candidates[i] == candidates[i - 1]) {
				continue;
			}
			if (target >= candidates[i]) {
				helper.add(candidates[i]);
				combinationSum(candidates, target - candidates[i], i + 1, helper, ans);
				helper.remove(helper.size() - 1);
			} else if (target > candidates[i]) {
				break;
			}

		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> combinationSum = combinationSumAnother(nums, 7);
		// System.out.println("Hello World");
		System.out.println(nums[3]);
		for (List<Integer> list : combinationSum) {
			System.out.println(list.toString());
		}
	}

}
