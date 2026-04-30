package codetop.page04.a11;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @create 2026/4/30 10:09
 */
public class Solution1 {
    private int maxHeight = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return maxHeight;
    }

    private void dfs(TreeNode root, int height) {
        if (root == null) {
            maxHeight = Math.max(maxHeight, height);
            return;
        }
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}
