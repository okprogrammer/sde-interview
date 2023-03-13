package tree.impl;

public class TreeNode<T> {

	public T data;
	public int hd;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode() {

	}

	public TreeNode(T data) {
		this.data = data;
	}

}
