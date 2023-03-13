package tree.impl;

import java.util.List;

public class MakeMirrorOfBT {
	static void mirror(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		mirror(root.left);
		mirror(root.right);
		TreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);
		root.right.left = new TreeNode<>(6);
		root.right.right = new TreeNode<>(7);
		List<List<Integer>> levelOrder = TreeImplementation.levelOrder(root);
		System.out.println(levelOrder);
		System.out.println("----------------Mirror of Tree------------------");
		mirror(root);
		List<List<Integer>> levelOrder2 = TreeImplementation.levelOrder(root);
		System.out.println(levelOrder2);
	}

}
