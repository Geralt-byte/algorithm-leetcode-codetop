package codetop.page05.a10;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * @create 2026/5/6 11:49
 */
public class Solution {

    private boolean result = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, int path) {
        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null && path == targetSum) {
                result = true;
                return;
            }
            if (root.left != null) {
                dfs(root.left, targetSum, path);
            }
            if (root.right != null) {
                dfs(root.right, targetSum, path);
            }
        }
    }
}
