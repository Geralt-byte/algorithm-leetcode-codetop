package codetop.page04.a11;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @create 2026/4/30 10:09
 */
public class Solution2 {

    private final List<List<Integer>> map = new ArrayList<>();

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return map.size();
    }

    private void dfs(TreeNode root, int height) {
        if (root != null) {
            if (height > map.size()) {
                map.add(new ArrayList<>());
                map.get(map.size() - 1).add(root.val);
            }
            if (root.left != null) dfs(root.left, height + 1);
            if (root.right != null) dfs(root.right, height + 1);
        }
    }
}
