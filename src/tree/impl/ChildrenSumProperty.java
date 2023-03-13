package tree.impl;

import java.util.List;

public class ChildrenSumProperty {

	static void changeTree(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		int child = 0;
		if (root.left != null) {
			child += root.left.data;
		}
		if (root.right != null) {
			child += root.right.data;
		}
		if (child >= root.data) {
			root.data = child;
		} else {
			if (root.left != null) {
				root.left.data = child;
			}
			if (root.right != null) {
				root.right.data = child;
			}
		}
		changeTree(root.left);
		changeTree(root.right);
		int tot = 0;
		if (root.left != null) {
			tot += root.left.data;
		}
		if (root.right != null) {
			tot += root.right.data;
		}
		if (root.left != null || root.right != null) {
			root.data = tot;
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
		changeTree(root);
		List<List<Integer>> ans = TreeImplementation.levelOrder(root);
		System.out.println("Level Traversal :" + ans);

	}

}
