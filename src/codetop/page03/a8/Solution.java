package codetop.page03.a8;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @create 2026/4/22 09:49
 */
public class Solution {

    private final List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            result.add(root.val);
            inOrder(root.right);
        }
    }
}
