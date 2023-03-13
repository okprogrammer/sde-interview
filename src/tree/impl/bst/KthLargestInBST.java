package tree.impl.bst;

import tree.impl.TreeNode;

public class KthLargestInBST {
	public int countNode(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int l = countNode(root.left);
		int r = countNode(root.right);
		return 1 + l + r;
	}

	public int kthLargest(TreeNode<Integer> root, int K) {
		int totalNode = countNode(root);
		K = totalNode - K + 1;
		// Your code here
		TreeNode<Integer> curr = root;
		while (curr != null) {
			if (curr.left == null) {
				K--;
				if (K == 0) {
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
					K--;
					if (K == 0) {
						return curr.data;
					}
					curr = curr.right;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}
