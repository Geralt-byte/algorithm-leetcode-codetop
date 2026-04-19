package codetop.page02.a14;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * @create 2026/4/19 09:05
 */
public class Solution {

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = 0, right = 0;
        if (root.left != null) {
            left = postOrder(root.left);
        }
        if (root.right != null) {
            right = postOrder(root.right);
        }
        result = Math.max(result, root.val);
        result = Math.max(result, root.val + left + right);
        result = Math.max(result, Math.max(root.val + left, root.val + right));
        return Math.max(Math.max(root.val + left, root.val + right), root.val);
    }
}
