package tree.impl.bst;

import java.util.LinkedList;
import java.util.Queue;

public class NextBinaryTree {

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node == null) {
				if (q.isEmpty()) {
					break;
				}
				q.add(null);
			} else {
				node.next = q.peek();
				if (node != null && node.left != null) {
					q.add(node.left);
				}
				if (node != null && node.right != null) {
					q.add(node.right);
				}

			}
		}
		return root;
	}

	public static void main(String[] args) {

	}

}
