package tree.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TreeImplementation {

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);
		root.right.left = new TreeNode<>(6);
		root.right.right = new TreeNode<>(7);
		System.out.println("============InOrder Traversal===========================");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("============PreOrder Traversal===========================");
		preOrderTraversal(root);
		System.out.println("===========Morris InOrder Traversal===============");
		List<Integer> inorderans = morrisInOrderTraversal(root);
		System.out.println();
		for (int i : inorderans) {
			System.out.print(i + " ");
		}
		System.out.println("===========Morris PreOrder Traversal===============");
		System.out.println();
		List<Integer> preOrderTraversal = morrisPreOrderTraversal(root);
		for (int i : preOrderTraversal) {
			System.out.print(i + " ");
		}
		System.out.println("==============left view tree==========================");
		List<Integer> leftViewTree = new ArrayList<>();
		leftView(root, leftViewTree, 0);
		for (int i : leftViewTree) {
			System.out.print(i + " ");
		}
		System.out.println("========================vertical traversal========================");
		List<List<Integer>> verticalTraversal = verticalOrderTraversal(root);
		System.out.println(verticalTraversal);
		System.out.println("===============all traversal ==============================");
		preInPostOrderTraversal(root);
		System.out.println("Level Order Traversal");
		List<List<Integer>> levelOrder = levelOrder(root);
		System.out.println(levelOrder);
	}

	private static List<Integer> morrisInOrderTraversal(TreeNode<Integer> root) {
		TreeNode<Integer> curr = root;
		List<Integer> inOrder = new ArrayList<>();
		while (curr != null) {
			if (curr.left == null) {
				inOrder.add(curr.data);
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
					inOrder.add(curr.data);
					curr = curr.right;
				}
			}
		}
		return inOrder;
	}

	private static List<Integer> morrisPreOrderTraversal(TreeNode<Integer> root) {
		TreeNode<Integer> curr = root;
		List<Integer> inOrder = new ArrayList<>();
		while (curr != null) {
			if (curr.left == null) {
				inOrder.add(curr.data);
				curr = curr.right;
			} else {
				TreeNode<Integer> prev = curr.left;
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = curr;
					inOrder.add(curr.data);
					curr = curr.left;
				} else {
					prev.right = null;
					curr = curr.right;
				}
			}
		}
		return inOrder;
	}

	private static void inOrderTraversal(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.println(root.data + " ");
		inOrderTraversal(root.right);
	}

	private static void preOrderTraversal(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	static void leftView(TreeNode<Integer> root, List<Integer> ds, int h) {
		if (root == null) {
			return;
		}
		if (h == ds.size()) {
			ds.add(root.data);
		}
		leftView(root.left, ds, h + 1);
		leftView(root.right, ds, h + 1);
	}

	static void righttView(TreeNode<Integer> root, List<Integer> ds, int h) {
		if (root == null) {
			return;
		}
		if (h == ds.size()) {
			ds.add(root.data);
		}
		leftView(root.right, ds, h + 1);
		leftView(root.left, ds, h + 1);
	}

	// vertical traversal
	static void verticalTraversal(TreeNode<Integer> root, Map<Integer, List<Integer>> map, int index) {
		if (root == null) {
			return;
		}
		if (map.containsKey(index)) {
			List<Integer> list = map.get(index);
			list.add(root.data);
			map.put(index, list);
		} else {
			List<Integer> list = new LinkedList<>();
			list.add(root.data);
			map.put(index, list);
		}
		verticalTraversal(root.left, map, index - 1);
		verticalTraversal(root.right, map, index + 1);

	}

	static List<List<Integer>> verticalTraversal(TreeNode<Integer> root) {
		List<List<Integer>> ans = new ArrayList<>();
		Map<Integer, List<Integer>> map = new TreeMap<>();
		verticalTraversal(root, map, 0);
		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			ans.add(e.getValue());
		}
		return ans;
	}

	// Function to return a list containing the bottom view of the given tree.
	static ArrayList<Integer> bottomView(TreeNode<Integer> root) {
		ArrayList<Integer> ds = new ArrayList<>();
		if (root == null) {
			return ds;
		}
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		root.hd = 0;
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode<Integer> node = q.remove();
			map.put(node.hd, node.data);
			int hd = node.hd;
			if (node.left != null) {
				node.left.hd = hd - 1;
				q.add(node.left);
			}
			if (node.right != null) {
				node.right.hd = hd + 1;
				q.add(node.right);
			}
		}
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			ds.add(e.getValue());
		}
		return ds;
	}

	// Function to return a list of nodes visible from the top view
	// from left to right in Binary Tree.
	static ArrayList<Integer> topView(TreeNode<Integer> root) {
		ArrayList<Integer> ds = new ArrayList<>();
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		root.hd = 0;
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode<Integer> node = q.remove();
			if (!map.containsKey(node.hd)) {
				map.put(node.hd, node.data);
			}
			int hd = node.hd;
			if (node.left != null) {
				node.left.hd = hd - 1;
				q.add(node.left);
			}
			if (node.right != null) {
				node.right.hd = hd - 1;
				q.add(node.right);
			}
		}
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			ds.add(e.getValue());
		}
		return ds;
	}

	static void preInPostOrderTraversal(TreeNode<Integer> root) {
		List<Integer> preOrder = new ArrayList<>();
		List<Integer> inOrder = new ArrayList<>();
		List<Integer> postOrder = new ArrayList<>();
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root, 1));
		if (root == null) {
			return;
		}
		while (!st.isEmpty()) {
			Pair pr = st.pop();
			if (pr.num == 1) {
				preOrder.add(pr.root.data);
				pr.num++;
				st.push(pr);
				if (pr.root.left != null) {
					st.push(new Pair(pr.root.left, 1));
				}
			} else if (pr.num == 2) {
				inOrder.add(pr.root.data);
				pr.num++;
				st.push(pr);
				if (pr.root.right != null) {
					st.push(new Pair(pr.root.right, 1));
				}
			} else {
				postOrder.add(pr.root.data);
			}
		}
		System.out.println("Pre Order Traversal");
		preOrder.stream().forEach(e -> System.out.println(e + " "));
		System.out.println("In Order Traversal");
		inOrder.stream().forEach(e -> System.out.println(e + " "));
		System.out.println("Post Order Traversal");
		postOrder.stream().forEach(e -> System.out.println(e + " "));
	}

	// 987. Vertical Order Traversal of a Binary Tree
	static List<List<Integer>> verticalOrderTraversal(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<>();
		q.offer(new Tuple(root, 0, 0));
		while (!q.isEmpty()) {
			Tuple tp = q.poll();
			int vertical = tp.vertical;
			int level = tp.level;
			if (!map.containsKey(vertical)) {
				map.put(vertical, new TreeMap<>());
			}
			if (!map.get(vertical).containsKey(level)) {
				map.get(vertical).put(level, new PriorityQueue<>());
			}
			map.get(vertical).get(level).offer(tp.root.data);
			if (tp.root.left != null) {
				q.offer(new Tuple(tp.root.left, vertical - 1, level + 1));
			}
			if (tp.root.right != null) {
				q.offer(new Tuple(tp.root.right, vertical + 1, level + 1));
			}
		}
		List<List<Integer>> list = new ArrayList<>();
		for (TreeMap<Integer, PriorityQueue<Integer>> e : map.values()) {
			list.add(new ArrayList<>());
			for (PriorityQueue<Integer> pq : e.values()) {
				while (!pq.isEmpty()) {
					list.get(list.size() - 1).add(pq.poll());
				}
			}
		}
		return list;
	}

	static void levelOrder(TreeNode<Integer> root, List<List<Integer>> list) {
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.add(null);
		List<Integer> l = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode<Integer> node = q.poll();
			if (node == null) {
				if (q.isEmpty()) {
					list.add(l);
					return;
				}
				list.add(l);
				l = new ArrayList<>();
				q.offer(null);
			} else {
				l.add(node.data);

				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
		}
	}

	static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		levelOrder(root, list);
		return list;
	}

}
