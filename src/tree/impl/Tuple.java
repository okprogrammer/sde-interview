package tree.impl;

public class Tuple {

	public TreeNode<Integer> root;
	public int vertical;
	public int level;

	public Tuple(TreeNode<Integer> root, int vertical, int level) {
		this.root = root;
		this.vertical = vertical;
		this.level = level;
	}

}
