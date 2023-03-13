package tree.impl.bst;

import java.util.Stack;

import tree.impl.TreeNode;

public class BSTIteratorWithTwoPairSolution {

	public Stack<TreeNode<Integer>> stack = new Stack<>();
	public boolean reverse;

	public BSTIteratorWithTwoPairSolution(TreeNode<Integer> root, boolean reverse) {
		this.reverse = reverse;
		pushAll(root);
	}

	public int next() {
		TreeNode<Integer> node = stack.pop();
		if (reverse) {
			pushAll(node.left);
		} else {
			pushAll(node.right);
		}
		return node.data;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public void pushAll(TreeNode<Integer> root) {
		for (; root != null;) {
			stack.push(root);
			if (reverse) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
	}

	public boolean findTarget(TreeNode<Integer> root, int k) {
		BSTIteratorWithTwoPairSolution it1 = new BSTIteratorWithTwoPairSolution(root, false);
		BSTIteratorWithTwoPairSolution it2 = new BSTIteratorWithTwoPairSolution(root, true);
		int i = it1.next();
		int j = it2.next();
		while (i < j) {
			if (i + j == k) {
				return true;
			} else if (i + j < k) {
				i = it1.next();
			} else {
				j = it2.next();
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
