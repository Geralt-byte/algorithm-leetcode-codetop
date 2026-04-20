package codetop.page02.a19;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @create 2026/4/20 09:21
 */
public class Solution1 {

    private final List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return result;
        dfs(root, 1);
        return result;
    }

    private void dfs(TreeNode root, int deep) {
        if (root != null) {
            if (deep > result.size()) {
                result.add(root.val);
            }
            if (root.right != null) {
                dfs(root.right, deep + 1);
            }
            if (root.left != null) {
                dfs(root.left, deep + 1);
            }
        }
    }
}
