package tree.impl;

import java.util.List;
import java.util.Stack;

public class FlattenBinaryTree {
	private static TreeNode<Integer> prev = null;

	public static void flatten(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}

	public static void flattenTreeUsingStack(TreeNode<Integer> root) {
		TreeNode<Integer> curr = null;
		Stack<TreeNode<Integer>> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			curr = st.peek();
			st.pop();
			if (curr.right != null) {
				st.push(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
			}
			if (!st.isEmpty()) {
				curr.right = st.peek();
			}
			curr.left = null;
		}
	}

	public static void flattenUsingWhileLoop(TreeNode<Integer> root) {
		TreeNode<Integer> curr = root;
		TreeNode<Integer> prev = null;
		while (curr != null) {
			if (curr.left != null) {
				prev = curr.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}

	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);
		root.right.left = new TreeNode<>(6);
		root.right.right = new TreeNode<>(7);
		// flatten(root);
		List<List<Integer>> levelOrder = TreeImplementation.levelOrder(root);
		System.out.println(levelOrder);
		System.out.println("========================================");
		// flattenTreeUsingStack(root);
		List<List<Integer>> ans2 = TreeImplementation.levelOrder(root);
		System.err.println(ans2);
		System.out.println("==============Using While loop==========================");
		flattenUsingWhileLoop(root);
		List<List<Integer>> ans3 = TreeImplementation.levelOrder(root);
		System.err.println(ans3);
	}

}
