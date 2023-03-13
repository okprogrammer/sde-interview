package tree.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructTreeFromInOrderAndPreOrder {

	static TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inMap = new HashMap<>();
		int inEnd = inorder.length;
		for (int i = 0; i < inEnd; i++) {
			inMap.put(inorder[i], i);
		}
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inEnd - 1, inMap);
	}

	private static TreeNode<Integer> buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
			int inEnd, Map<Integer, Integer> inMap) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		TreeNode<Integer> root = new TreeNode<>(preorder[preStart]);
		int inRoot = inMap.get(root.data);
		int numsLeft = inRoot - inStart;
		root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
		root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
		return root;
	}

	public static void main(String[] args) {
		int[] preoder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		TreeNode<Integer> root = buildTree(preoder, inorder);
		List<List<Integer>> ans = TreeImplementation.levelOrder(root);
		System.out.println(ans);
	}

}
