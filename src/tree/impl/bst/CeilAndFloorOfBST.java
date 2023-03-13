package tree.impl.bst;

import tree.impl.TreeNode;

public class CeilAndFloorOfBST {

    public static int findCeil(TreeNode<Integer> node, int x) {
	int ceil = -1;
	while (node != null) {
	    if (node.data == x) {
		ceil = node.data;
		return ceil;
	    }
	    if (x > node.data) {
		node = node.right;
	    } else {
		ceil = node.data;
		node = node.left;
	    }

	}
	return ceil;
    }

    public static int findFloor(TreeNode<Integer> node, int x) {
	int floor = -1;
	while (node != null) {
	    if (node.data == x) {
		floor = node.data;
		return floor;
	    }
	    if (x < node.data) {
		node = node.left;
	    } else {
		floor = node.data;
		node = node.right;
	    }

	}
	return floor;
    }

    public static void main(String[] args) {
	TreeNode<Integer> root = new TreeNode<>(4);
	root.left = new TreeNode<>(2);
	root.right = new TreeNode<>(6);
	root.left.left = new TreeNode<>(1);
	root.left.right = new TreeNode<>(3);
	root.right.left = new TreeNode<>(5);
	root.right.right = new TreeNode<>(7);
	int findCeil = findCeil(root, 0);
	System.out.println(findCeil);
    }

}
