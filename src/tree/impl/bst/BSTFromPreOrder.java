package tree.impl.bst;

import tree.impl.TreeNode;

public class BSTFromPreOrder {
    static TreeNode<Integer> bstFromPreorderUsingRec(int[] preorder, int data, TreeNode<Integer> root) {
	TreeNode<Integer> node = new TreeNode<>(data);
	if (root == null) {
	    return node;
	}
	if (root.data > data) {
	    root.left = bstFromPreorderUsingRec(preorder, data, root.left);
	} else if (root.data < data) {
	    root.right = bstFromPreorderUsingRec(preorder, data, root.right);
	}
	return root;
    }

    static TreeNode<Integer> bstFromPreorderRec(int[] preorder, int ubound, int[] A) {
	if (A[0] == preorder.length || (ubound < preorder[A[0]])) {
	    return null;
	}
	TreeNode<Integer> root = new TreeNode<>(preorder[A[0]++]);
	root.left = bstFromPreorderRec(preorder, root.data, A);
	root.right = bstFromPreorderRec(preorder, ubound, A);
	return root;
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
	int[] preorder = new int[] { 8, 5, 1, 7, 10, 12 };
	TreeNode<Integer> root = null;
	int n = preorder.length;
	for (int i = 0; i < n; i++) {
	    root = bstFromPreorderUsingRec(preorder, preorder[i], root);
	}

	System.out.println("---------preorder------------");
	preOrderTraversal(root);
	TreeNode<Integer> root1 = bstFromPreorderRec(preorder, Integer.MAX_VALUE, new int[] { 0 });
	System.out.println("---------without recursion------------------");
	preOrderTraversal(root1);
    }

}
