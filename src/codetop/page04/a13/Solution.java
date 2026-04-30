package codetop.page04.a13;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树，判断它是否是 平衡二叉树
 * @create 2026/4/30 10:44
 */
public class Solution {

    private boolean judge = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return judge;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) {
            judge = false;
        }
        return 1 + Math.max(left, right);
    }
}
