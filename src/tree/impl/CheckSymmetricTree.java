package tree.impl;

public class CheckSymmetricTree {

	public static boolean isSymmetric(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if (root1 == null || root2 == null) {
			return root1 == root2;
		}
		if (root1.data != root2.data) {
			return false;
		}
		return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
	}

	public static boolean isSymmetric(TreeNode<Integer> root) {
		return root == null || isSymmetric(root, root);
	}

	public static void main(String[] args) {

	}

}
