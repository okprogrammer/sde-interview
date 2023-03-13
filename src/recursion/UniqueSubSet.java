package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class UniqueSubSet.
 */
public class UniqueSubSet {

	/**
	 * ***********************************
	 * 4th Approach Without recursion
	 * ******************************.
	 *
	 * @param nums the nums
	 * @return the list
	 */
	static List<List<Integer>> subsetWithoutDuplicateAnotherApproach(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		findSubset(0, nums, res, new ArrayList<>());
		return res;
	}

	/**
	 * Find subset.
	 *
	 * @param index the index
	 * @param nums the nums
	 * @param res the res
	 * @param helper the helper
	 */
	private static void findSubset(int index, int[] nums, List<List<Integer>> res, List<Integer> helper) {
		res.add(List.copyOf(helper));
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1])continue;
			helper.add(nums[i]);
			findSubset(i + 1, nums, res, helper);
			helper.remove(helper.size() - 1);
		}
	}

	/**
	 * ***********************************
	 * 3rd Approach Without recursion
	 * ******************************.
	 *
	 * @param nums the nums
	 * @return the list
	 */
	private static List<List<Integer>> subsetFindBitApproach(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < (1 << n); i++) {
			List<Integer> smallRes = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (((1 << j) & i) != 0) {
					smallRes.add(nums[j]);
				}
			}
			// just for unique subset
			if (!list.contains(smallRes)) {
				list.add(smallRes);
			}
		}
		return list;
	}

	/**
	 * ***********************************
	 * 2nd Approach
	 * ******************************.
	 *
	 * @param nums the nums
	 * @return the list
	 */

	static List<List<Integer>> subsetsWithoutDuplicate(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		HashSet<List<Integer>> res = new HashSet<>();
		List<Integer> helper = new ArrayList<>();
		subsetsWithoutDuplicate(nums, 0, helper, res);
		for (List<Integer> list : res) {
			ans.add(list);
		}
		Collections.sort(ans, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.size() - o2.size();
			}
		});
		return ans;
	}

	/**
	 * Subsets without duplicate.
	 *
	 * @param nums the nums
	 * @param i the i
	 * @param helper the helper
	 * @param res the res
	 */
	private static void subsetsWithoutDuplicate(int[] nums, int i, List<Integer> helper, HashSet<List<Integer>> res) {
		if (i == nums.length) {
			Collections.sort(helper);
			List<Integer> l = List.copyOf(helper);
			res.add(l);
			return;
		}
		helper.add(nums[i]);
		subsetsWithoutDuplicate(nums, i + 1, helper, res);
		helper.remove(helper.size() - 1);
		subsetsWithoutDuplicate(nums, i + 1, helper, res);
	}

	/**
	 * ***********************************
	 * 1st Approach
	 * ******************************.
	 *
	 * @param nums the nums
	 * @return the list
	 */
	/**
	 * Subsets with dup.
	 *
	 * @param nums the nums
	 * @return the list
	 */
	// return subset with unique list
	static List<List<Integer>> subsetsWithDup(int[] nums) {
		int n = nums.length;
		// to print in the sorted and right sequence
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		subsetsWithDup(nums, 0, n, ans, list);
		Collections.sort(ans, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.size() - o2.size();
			}
		});
		return ans;
	}

	/**
	 * Subsets with dup.
	 *
	 * @param nums the nums
	 * @param i    the i
	 * @param n    the n
	 * @param ans  the ans
	 * @param list the list
	 */
	static void subsetsWithDup(int[] nums, int i, int n, List<List<Integer>> ans, List<Integer> list) {
		if (i == n) {
			List<Integer> l = List.copyOf(list);
			if (ans.contains(l)) {
				return;
			}
			ans.add(0, l);
			return;
		}
		list.add(nums[i]);
		subsetsWithDup(nums, i + 1, n, ans, list);
		list.remove(list.size() - 1);
		subsetsWithDup(nums, i + 1, n, ans, list);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 2 };
//		List<List<Integer>> subsetsWithDup = subsetsWithDup(nums);
//		for (int i = 0; i < subsetsWithDup.size(); i++) {
//			for (int j = 0; j < subsetsWithDup.get(i).size(); j++) {
//				System.out.print(subsetsWithDup.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
		List<List<Integer>> ans = subsetWithoutDuplicateAnotherApproach(nums);
		for (List<Integer> list : ans) {
			System.out.println(list.toString());
		}
	}

}
