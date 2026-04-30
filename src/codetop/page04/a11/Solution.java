package codetop.page04.a11;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @create 2026/4/30 10:09
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            height++;
            int width = deque.size();
            for (int i = 0; i < width; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return height;
    }
}
