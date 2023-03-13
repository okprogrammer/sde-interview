package binarysearchproblems;

import java.awt.image.ImageProducer;
import java.util.function.Consumer;

public class FindSingleElementInArray {

	static int singleNonDuplicate(int[] nums) {
		int start = 0;
		// we are taking end as second last because if break point present at the last
		// index then start will move one by one
		int end = nums.length - 2;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (mid % 2 == 0) {
				if (nums[mid] != nums[mid + 1]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (nums[mid] == nums[mid + 1]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return nums[start];
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		int value = singleNonDuplicate(input);
		System.out.println(value);
	}

}
