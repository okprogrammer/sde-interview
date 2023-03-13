package tree.impl.bst;

import tree.impl.TreeNode;
import static tree.impl.bst.BSTImplementation.insertIntoBST;

public class InOrderSuccessor {

	static TreeNode<Integer> inOrderSuccessor(TreeNode<Integer> root, TreeNode<Integer> p) {
		TreeNode<Integer> successor = null;
		while (root != null) {
			if (p.data >= root.data) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}

	static TreeNode<Integer> inOrderPredecessor(TreeNode<Integer> root, TreeNode<Integer> p) {
		if (root == null) {
			return null;
		}
		TreeNode<Integer> predecessor = null;
		while (root != null) {
			if (root.data >= p.data) {
				root = root.left;
			} else {
				predecessor = root;
				root = root.right;
			}
		}
		return predecessor;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = insertIntoBST(null, 5);
		root = insertIntoBST(root, 3);
		root = insertIntoBST(root, 6);
		root = insertIntoBST(root, 2);
		root = insertIntoBST(root, 4);
		root = insertIntoBST(root, 7);
		System.out.println(inOrderSuccessor(root, new TreeNode<Integer>(1)).data);
	}

}
