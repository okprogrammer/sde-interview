package tree.impl.bst;

import tree.impl.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode<Integer> root) {
	return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode<Integer> root, long lbound, long ubound) {
	if (root == null) {
	    return true;
	}
	if (root.data <= lbound || root.data >= ubound) {
	    return false;
	}
	return isValidBST(root.left, lbound, root.data) && isValidBST(root.right, root.data, ubound);
    }

    public static void main(String[] args) {

    }

}
