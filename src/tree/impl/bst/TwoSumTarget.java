package tree.impl.bst;

import java.util.ArrayList;
import java.util.List;

import tree.impl.TreeNode;

public class TwoSumTarget {
	static void inOrder(TreeNode<Integer> root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.data);
		inOrder(root.right, list);
	}

	static boolean findTarget(TreeNode<Integer> root, int k) {
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		int start = 0;
		int end = list.size() - 1;
		while (start < end) {
			int sum = list.get(start) + list.get(end);
			if (sum < k) {
				start++;
			} else if (sum > k) {
				end--;
			} else {
				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) {

	}

}
