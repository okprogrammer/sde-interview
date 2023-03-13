package linkedlistarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayLinkedList {

	static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {

			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];

				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[lo]);
						temp.add(nums[hi]);
						res.add(temp);

						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;

						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						lo++;

					else
						hi--;
				}
			}
		}
		return res;
	}

	static int trap(int[] height) {
		int leftSum = 0;
		int i = 0;
		int n = height.length;
		int maxWater = 0;
		while (i < n) {
			leftSum = Math.max(leftSum, height[i]);
			int j = i;
			int rightSum = 0;
			while (j < n) {
				rightSum = Math.max(rightSum, height[j]);
				j++;
			}
			maxWater = maxWater + Math.min(leftSum, rightSum) - height[i];
			i++;
		}
		return maxWater;
	}

	static int trapOptimize(int[] height) {
		int n = height.length;
		int[] prefixArr = new int[n];
		int[] suffixArr = new int[n];
		int leftMax = 0;
		int rightMax = 0;
		int maxHeight = 0;
		for (int i = 0; i < n; i++) {
			leftMax = Math.max(leftMax, height[i]);
			prefixArr[i] = leftMax;
			rightMax = Math.max(rightMax, height[n - i - 1]);
			suffixArr[n - i - 1] = rightMax;
		}
		for (int i = 0; i < n; i++) {
			maxHeight = maxHeight + Math.min(prefixArr[i], suffixArr[i]) - height[i];
		}
		return maxHeight;
	}

	static int trapOptimize2(int[] height) {
		int leftMax = 0;
		int rightMax = 0;
		int maxHeight = 0;
		int left = 0;
		int right = height.length - 1;
		while (left <= right) {
			if (height[left] <= height[right]) {
				if (leftMax <= height[left]) {
					leftMax = height[left];
				} else {
					maxHeight += leftMax - height[left];
				}
				left++;
			} else {
				if (rightMax <= height[right]) {
					rightMax = height[right];
				} else {
					maxHeight += rightMax - height[right];
				}
				right--;
			}
		}
		return maxHeight;
	}

	static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int prev = nums[0];
		int currIndex = 1;
		if (nums.length == 1) {
			return currIndex;
		}
		for (int i = 1; i < n; i++) {
			int curr = nums[i];
			if (prev != curr) {
				nums[currIndex] = curr;
				currIndex++;
				prev = curr;
			}

		}
		return currIndex - 1;
	}

	static int findMaxConsecutiveOnes(int[] nums) {
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
				maxCount = Math.max(maxCount, count);
			} else {
				count = 0;
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
//		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//		int ans = trap(arr);
//		ans = trapOptimize2(arr);
//		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
//		int ans = removeDuplicates(nums);
//		System.out.println(ans);
		int[] nums  = {1,1,0,1,1,1};
		int ans = findMaxConsecutiveOnes(nums);
		System.out.println(ans);
	}

}
