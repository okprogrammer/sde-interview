package tree.impl.bst;

import tree.impl.TreeNode;

public class LcaOfANodeInBST {
	public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
		if (root == null) {
			return null;
		}
		int curr = root.data;
		if (curr < p.data && curr < q.data) {
			return lowestCommonAncestor(root.right, p, q);
		}
		if (curr > p.data && curr > q.data) {
			return lowestCommonAncestor(root.left, p, q);
		}
		return root;
	}

	public static void main(String[] args) {

	}
}
