package tree.impl.bst;

import java.math.MathContext;

import tree.impl.TreeNode;

class NodeValue {
	public boolean isSign;
	public long minNode;
	public long maxNode;
	public int maxSum;

	public NodeValue(long minNode, long maxNode, int maxSum, boolean isSign) {
		this.isSign = isSign;
		this.minNode = minNode;
		this.maxNode = maxNode;
		this.maxSum = maxSum;
	}
}

public class MaxBSTSUM {

	static int maxSumBST(TreeNode<Integer> root) {

		return maxSumBSTHelper(root).maxSum;
	}

	private static NodeValue maxSumBSTHelper(TreeNode<Integer> root) {
		if (root == null) {
			return new NodeValue(Long.MAX_VALUE, Long.MIN_VALUE, 0, true);
		}
		NodeValue left = maxSumBSTHelper(root.left);
		NodeValue right = maxSumBSTHelper(root.right);
		if (root.left == null && root.right == null) {
			return new NodeValue(root.data, root.data, root.data, true);
		}
		if (left.isSign && right.isSign && root.data > left.maxNode && root.data < right.minNode) {
			int sum = Math.max((root.data + left.maxSum + right.maxSum), Math.max(left.maxSum, right.maxSum));
			return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), sum, true);
		}
		// otherwise return [-inf,+inf,0] so root can't be BST
		return new NodeValue(Long.MIN_VALUE, Long.MAX_VALUE, Math.max(left.maxSum, right.maxSum), false);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.right = new TreeNode<>(10);
		root.right.left = new TreeNode<>(-5);
		root.right.right = new TreeNode<>(20);
		int maxSumBST = maxSumBST(root);
		System.out.println(maxSumBST);
	}

}
