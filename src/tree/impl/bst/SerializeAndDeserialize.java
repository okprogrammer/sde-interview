package tree.impl.bst;

import tree.impl.TreeNode;

public class SerializeAndDeserialize {

	// Encodes a tree to a single string.
	public String serialize(TreeNode<Integer> root) {
		if (root == null) {
			return "$";
		}
		return root.data + " " + serialize(root.left) + " " + serialize(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode<Integer> deserialize(String data) {
		String[] split = data.split(" ");
		TreeNode<Integer> root = constructTree(split, new int[] { 0 });
		return root;
	}

	private TreeNode<Integer> constructTree(String[] data, int[] index) {
		String c = index[0] < data.length ? data[index[0]] : "$";
		if (c.equals("$")) {
			return null;
		}
		TreeNode<Integer> root = new TreeNode<>(Integer.parseInt(c));
		index[0]++;
		root.left = constructTree(data, index);
		index[0]++;
		root.right = constructTree(data, index);
		return root;
	}

	static void inOrder(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		inOrder(root.left);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.right = new TreeNode<>(10);
		root.right.left = new TreeNode<>(-5);
		root.right.right = new TreeNode<>(20);
		SerializeAndDeserialize s = new SerializeAndDeserialize();
		String serialize = s.serialize(root);
		System.out.println("Serialize");
		System.out.println(serialize);
		System.out.println("Serlize string.");
		System.out.println(serialize.length());
		System.out.println("Deserialize");
		TreeNode<Integer> dRoot = s.deserialize(serialize);
		System.out.println("Traverse deserialize node");
		inOrder(dRoot);
		System.out.println();
		System.out.println("Serialize");
		System.out.println(s.serialize(dRoot));

	}

}
