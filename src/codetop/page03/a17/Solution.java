package codetop.page03.a17;

import hot100.tree.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @create 2026/4/26 13:46
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, preorder.length - 1, 0);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> map, int preLeft, int PreRight, int inLeft) {
        if (preLeft > PreRight) return null;
        else if (preLeft == PreRight) return new TreeNode(preorder[preLeft]);
        else {
            int inIndex = map.get(preorder[preLeft]);
            int leftLen = inIndex - inLeft;
            TreeNode root = new TreeNode(preorder[preLeft]);
            root.left = build(preorder, map, preLeft + 1, preLeft + leftLen, inLeft);
            root.right = build(preorder, map, preLeft + leftLen+1, PreRight, inIndex + 1);
            return root;
        }// 0 1 2 3 4 5
    }
}
