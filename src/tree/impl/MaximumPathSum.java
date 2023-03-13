package tree.impl;

public class MaximumPathSum {
	public static int maxPathSum(TreeNode<Integer> root) {
		int[] ans = new int[1];
		ans[0] = Integer.MIN_VALUE;
		maxPathSum(root, ans);
		return ans[0];
	}

	private static int maxPathSum(TreeNode<Integer> root, int[] ans) {
		if (root == null) {
			return 0;
		}
		// find left path sum
		int leftPathSum = Math.max(0, maxPathSum(root.left, ans));
		// find right path sum
		int rightPathSum = Math.max(0, maxPathSum(root.right, ans));
		// adding path sum (includes root node value)
		ans[0] = Math.max(ans[0], leftPathSum + rightPathSum + root.data);
		// return the maximum path sum
		return root.data + Math.max(leftPathSum, rightPathSum);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(-5);
		root.right.left = new TreeNode<>(-6);
		root.right.right = new TreeNode<>(7);
		int maxPathSum = maxPathSum(root);
		System.out.println("Sum of maximum path :" + maxPathSum);
	}
}
