package tree.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeProblemSolve {
	static ArrayList<Integer> getPath(TreeNode<Integer> root, int B) {
		ArrayList<Integer> list = new ArrayList<>();
		if (isPathPresent(root, B, list)) {
			return list;
		}
		return null;
	}

	static boolean isPathPresent(TreeNode<Integer> root, int b, ArrayList<Integer> list) {
		if (root == null) {
			return false;
		}
		list.add(root.data);
		if (root.data == b) {
			return true;
		}
		if (isPathPresent(root.left, b, list) || isPathPresent(root.right, b, list)) {
			return true;
		}
		list.remove(list.size() - 1);
		return false;
	}

	// maximum widht of binary tree
	static int widthOfBinaryTree(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		Queue<Pair> q = new LinkedList<>();
		int ans = Integer.MIN_VALUE;
		int curr_ind = 0;
		q.offer(new Pair(root, curr_ind));
		int first = 0;
		int last = 0;
		while (!q.isEmpty()) {
			Pair p = q.peek();
			int mmin = p.num;
			int size = q.size();
			first = 0;
			last = 0;
			for (int i = 0; i < size; i++) {
				curr_ind = q.peek().num - mmin;
				TreeNode<Integer> node = q.peek().root;
				if (i == 0) {
					first = curr_ind;
				}
				if (i == size - 1) {
					last = curr_ind;
				}
				q.poll();
				if (node.left != null) {
					q.offer(new Pair(node.left, 2 * curr_ind + 1));
				}
				if (node.right != null) {
					q.offer(new Pair(node.right, 2 * curr_ind + 2));
				}
			}
			ans = Math.max(ans, last - first + 1);
		}
		return ans;
	}

	static int maxDepth(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);
		int ans = Math.max(lh, rh);
		return ans + 1;
	}

	static int height(TreeNode<Integer> root, int[] diameter) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left, diameter);
		int rh = height(root.right, diameter);
		diameter[0] = Math.max(diameter[0], lh + rh);
		return 1 + Math.max(lh, rh);
	}

	static int diameterOfBinaryTree(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int[] diameter = new int[1];
		height(root, diameter);
		return diameter[0];
	}

	static boolean isBalanced(TreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);
		if (!(Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))) {
			return false;
		}
		return true;
	}

	public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p,
			TreeNode<Integer> q) {
		if (root == null) {
			return null;
		}
		if (root.equals(p) || root.equals(q)) {
			return root;
		}
		TreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
		TreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public boolean isSameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
		if (p == null || q == null) {
			return (p == q);
		}
		return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
		List<List<Integer>> list = new ArrayList<>();
		Stack<TreeNode<Integer>> currStack = new Stack<>();
		Stack<TreeNode<Integer>> nextStack = new Stack<>();
		if (root == null) {
			return list;
		}
		boolean flip = true;
		currStack.push(root);
		List<Integer> partList = new ArrayList<>();
		while (!currStack.isEmpty()) {
			TreeNode<Integer> node = currStack.pop();
			partList.add(node.data);
			if (flip) {
				if (node.left != null) {
					nextStack.push(node.left);
				}
				if (node.right != null) {
					nextStack.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextStack.push(node.right);
				}
				if (node.left != null) {
					nextStack.push(node.left);
				}
			}
			if (currStack.isEmpty()) {
				Stack<TreeNode<Integer>> tempStack = nextStack;
				nextStack = currStack;
				currStack = tempStack;
				flip = !flip;
				list.add(partList);
				partList = new ArrayList<>();
			}
		}
		// list.add(partList);
		return list;
	}


	private static void getLeafNode(TreeNode<Integer> root, List<Integer> list) {
		if (root == null) {
			return;
		}
		getLeafNode(root.left, list);
		getLeafNode(root.right, list);
		if (root.left == null || root.right == null) {
			list.add(root.data);
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);
		root.right.left = new TreeNode<>(6);
		root.right.right = new TreeNode<>(7);
		ArrayList<Integer> path = getPath(root, 5);
		System.out.println(path);
		int ans = widthOfBinaryTree(root);
		System.out.println(ans);
		System.out.println("Height of Binary Tree: " + maxDepth(root));
		System.out.println("Diameter of Binary Tree: " + diameterOfBinaryTree(root));
		System.out.println("Check treee is balanced " + isBalanced(root));
		System.out.println("LCA of 2 and 6 :" + lowestCommonAncestor(root, root.left, root.right.left).data);
		System.out.println("Zig Zag traversal :" + zigzagLevelOrder(root));
	}

}
