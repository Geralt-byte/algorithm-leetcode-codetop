package codetop.page05.a4;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * @create 2026/5/5 10:38
 */
public class Solution {

    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right + 1);
        return 1 + Math.max(left, right);
    }
}
