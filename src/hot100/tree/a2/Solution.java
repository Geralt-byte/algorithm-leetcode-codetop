package hot100.tree.a2;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @create 2026/3/22 13:51
 */
public class Solution {
    //递归
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
