package codetop.page04.a2;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * @create 2026/4/27 07:23
 */
public class Solution {

    private int result = 0;
    private int path = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            path = path * 10 + root.val;
            if (root.left == null && root.right == null) {
                result += path;
            } else {
                dfs(root.left);
                if (root.left != null) {
                    path = path - root.left.val;
                    path /= 10;
                }
                dfs(root.right);
                if (root.right != null) {
                    path = path - root.right.val;
                    path /= 10;
                }
            }
        }
    }
}
