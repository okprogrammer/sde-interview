package tree.impl.bst;

import tree.impl.TreeNode;

public class KthSmallestInBST {

	static int kthSmallest(TreeNode<Integer> root, int k) {
		TreeNode<Integer> curr = root;
		while (curr != null) {
			if (curr.left == null) {
				k--;
				if (k == 0) {
					return curr.data;
				}
				curr = curr.right;
			} else {
				TreeNode<Integer> prev = curr.left;
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				} else {
					prev.right = null;
					k--;
					if (k == 0) {
						return curr.data;
					}
					curr = curr.right;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
