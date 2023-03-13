package tree.impl.bst;

import tree.impl.TreeNode;

public class SortedArrayToBST {

    static TreeNode<Integer> sortedArrayToBST(int[] nums, int start, int end) {
	if (start > end) {
	    return null;
	}
	int mid = (start + end) / 2;
	TreeNode<Integer> root = new TreeNode<>(nums[mid]);
	root.left = sortedArrayToBST(nums, start, mid - 1);
	root.right = sortedArrayToBST(nums, mid + 1, end);
	return root;
    }

    static void inOrderTraversal(TreeNode<Integer> root) {
	if (root == null) {
	    return;
	}
	inOrderTraversal(root.left);
	System.out.print(root.data + " ");
	inOrderTraversal(root.right);
    }

    static void preOrderTraversal(TreeNode<Integer> root) {
	if (root == null) {
	    return;
	}
	System.out.print(root.data + " ");
	preOrderTraversal(root.left);
	preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
	int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	TreeNode<Integer> root = sortedArrayToBST(nums, 0, nums.length - 1);
	inOrderTraversal(root);
	
    }

}
