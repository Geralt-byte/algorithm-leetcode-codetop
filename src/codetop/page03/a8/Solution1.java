package codetop.page03.a8;

import hot100.tree.pojo.TreeNode;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @create 2026/4/22 09:49
 */
public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    if (node.right != null) stack.push(node.right);
                    stack.push(node);
                    stack.push(null);
                    if (node.left != null) stack.push(node.left);
                } else {
                    node = stack.pop();
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
