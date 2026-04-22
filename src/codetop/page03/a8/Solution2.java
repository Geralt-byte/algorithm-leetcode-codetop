package codetop.page03.a8;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @create 2026/4/22 09:49
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            while (!stack.isEmpty() || p != null) {
                if (p != null) {
                    stack.push(p);
                    p = p.left;
                } else {
                    TreeNode node = stack.pop();
                    result.add(node.val);
                    p = node.right;
                }
            }
        }
        return result;
    }
}
