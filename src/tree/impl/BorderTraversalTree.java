package tree.impl;

import java.util.ArrayList;
import java.util.List;

public class BorderTraversalTree {

	static List<Integer> printBoundary(TreeNode<Integer> root) {
		List<Integer> list = new ArrayList<>();
		list.add(root.data);
		addLeftBoundaryTree(root, list);
		addLeavesBinaryTree(root, list);
		addRightBoundaryTree(root, list);
		return list;
	}

	private static void addRightBoundaryTree(TreeNode<Integer> root, List<Integer> list) {
		List<Integer> tempList = new ArrayList<>();
		TreeNode<Integer> curr = root.right;
		while (curr != null) {
			if (!isLeaf(curr)) {
				tempList.add(curr.data);
			}
			if (curr.right != null) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		int size = tempList.size() - 1;
		for (int i = size; i >= 0; i--) {
			list.add(tempList.get(i));
		}
	}

	private static void addLeavesBinaryTree(TreeNode<Integer> root, List<Integer> list) {
		if (isLeaf(root)) {
			list.add(root.data);
			return;
		}
		if (root.left != null) {
			addLeavesBinaryTree(root.left, list);
		}
		if (root.right != null) {
			addLeavesBinaryTree(root.right, list);
		}
	}

	private static void addLeftBoundaryTree(TreeNode<Integer> root, List<Integer> list) {
		TreeNode<Integer> curr = root.left;
		while (curr != null) {
			if (!isLeaf(curr)) {
				list.add(curr.data);
			}
			if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
	}

	private static boolean isLeaf(TreeNode<Integer> curr) {
		if (curr.left == null && curr.right == null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);
		root.right.left = new TreeNode<>(6);
		root.right.right = new TreeNode<>(7);
		List<Integer> ans = printBoundary(root);
		System.out.println("Boundary Traversal :" + ans);

	}

}
