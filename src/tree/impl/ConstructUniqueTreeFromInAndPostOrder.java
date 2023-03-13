package tree.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructUniqueTreeFromInAndPostOrder {
	public static TreeNode<Integer> buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inMap = new HashMap<>();
		int inEnd = inorder.length;
		for (int i = 0; i < inEnd; i++) {
			inMap.put(inorder[i], i);
		}
		return buildTree(inorder, 0, inEnd - 1, postorder, 0, postorder.length - 1, inMap);
	}

	private static TreeNode<Integer> buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
			int postEnd, Map<Integer, Integer> inMap) {
		if ((inStart > inEnd) || (postStart > postEnd)) {
			return null;
		}
		TreeNode<Integer> root = new TreeNode<>(postorder[postEnd]);
		int inTree = inMap.get(root.data);
		int numsLeft = inTree - inStart;
		root.left = buildTree(inorder, inStart, inTree - 1, postorder, postStart, postStart + numsLeft - 1, inMap);
		root.right = buildTree(inorder, inTree + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, inMap);
		return root;
	}

	public static void main(String[] args) {
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		int[] postorder = new int[] { 9, 15, 7, 20, 3 };
		TreeNode<Integer> root = buildTree(inorder, postorder);
		List<List<Integer>> levelOrder = TreeImplementation.levelOrder(root);
		System.out.println(levelOrder);
	}

}
