package tree.impl.bst;

import tree.impl.TreeNode;

/**
 * The Class BSTImplmentation.
 */
public class BSTImplementation {

	/**
	 * Search BST.
	 *
	 * @param root the root
	 * @param val  the val
	 * @return the tree node
	 */
	static TreeNode<Integer> searchBST(TreeNode<Integer> root, int val) {
		if (root == null) {
			return null;
		}
		if (root.data == val) {
			return root;
		} else if (root.data < val) {
			return searchBST(root.right, val);
		} else {
			return searchBST(root.left, val);
		}
	}

	/**
	 * Search BST without rec.
	 *
	 * @param root the root
	 * @param val  the val
	 * @return the tree node
	 */
	static TreeNode<Integer> searchBSTWithoutRec(TreeNode<Integer> root, int val) {
		TreeNode<Integer> curr = root;
		while (curr != null && curr.data != val) {
			curr = curr.data > val ? curr.left : curr.right;
		}
		return curr;
	}

	/**
	 * Insert into BST.
	 *
	 * @param root the root
	 * @param val  the val
	 * @return the tree node
	 */
	public static TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int val) {
		TreeNode<Integer> curr = root;
		if (curr == null) {
			return new TreeNode<>(val);
		}
		while (true) {
			if (curr.data <= val) {
				if (curr.right != null) {
					curr = curr.right;
				} else {
					curr.right = new TreeNode<>(val);
					break;
				}
			} else {
				if (curr.left != null) {
					curr = curr.left;
				} else {
					curr.left = new TreeNode<>(val);
					break;
				}
			}
		}
		return root;
	}

	/**
	 * Insert into BST with rec.
	 *
	 * @param root the root
	 * @param val  the val
	 * @return the tree node
	 */
	static TreeNode<Integer> insertIntoBSTWithRec(TreeNode<Integer> root, int val) {
		if (root == null) {
			return new TreeNode<>(val);
		}
		if (root.data <= val) {
			root.right = insertIntoBSTWithRec(root.right, val);
		} else {
			root.left = insertIntoBSTWithRec(root.left, val);
		}
		return root;
	}

	static TreeNode<Integer> deleteNodeRec(TreeNode<Integer> root, int key) {
		if (root == null) {
			return null;
		}
		if (root.data < key) {
			root.right = deleteNodeRec(root.right, key);
		} else if (root.data > key) {
			root.left = deleteNodeRec(root.left, key);
		} else {
			// root don't have left subtree
			if (root.left == null) {
				root = root.right;
			}
			// root don't have right subtree
			else if (root.right == null) {
				root = root.left;
			}
			// have left and right subtree
			else {
				TreeNode<Integer> minNode = getMinNode(root.right);
				root.data = minNode.data;
				root.right = deleteNodeRec(root.right, minNode.data);
				return root;
			}
			// return root;
		}
		return root;
	}

	private static TreeNode<Integer> getMinNode(TreeNode<Integer> root) {
		if (root.left == null) {
			return root;
		}
		return getMinNode(root.left);
	}

	static TreeNode<Integer> deleteNodeWithoutRec(TreeNode<Integer> root, int key) {
		if (root == null) {
			return null;
		}
		TreeNode<Integer> curr = root;
		if (root.data == key) {
			return deleteHelper(root);
		}
		while (root != null) {
			if (root.data > key) {
				if (root.left != null && root.left.data == key) {
					root.left = deleteHelper(root.left);
					break;
				} else {
					root = root.left;
				}
			} else {
				if (root.right != null && root.right.data == key) {
					root.right = deleteHelper(root.right);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return curr;
	}

	private static TreeNode<Integer> deleteHelper(TreeNode<Integer> root) {
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		} else {
			TreeNode<Integer> rightChild = root.right;
			TreeNode<Integer> lastRightChild = getRightMostChild(root.left);
			lastRightChild.right = rightChild;
			return root.left;
		}
	}

	private static TreeNode<Integer> getRightMostChild(TreeNode<Integer> root) {
		if (root.right == null) {
			return root;
		}
		return getRightMostChild(root.right);
	}

	static void preOrderTraversal(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		TreeNode<Integer> root = insertIntoBST(null, 5);
		root = insertIntoBST(root, 3);
		root = insertIntoBST(root, 6);
		root = insertIntoBST(root, 2);
		root = insertIntoBST(root, 4);
		root = insertIntoBST(root, 7);
		TreeNode<Integer> ans1 = deleteNodeRec(root, 7);
		// TreeNode<Integer> ans = deleteNodeWithoutRec(root, 4);
		preOrderTraversal(ans1);
//	TreeNode<Integer> node = searchBSTWithoutRec(ans1, 2);
//	System.out.println(node != null ? node.data : node);
	}

}
