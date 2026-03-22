package hot100.tree.a1;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @create 2026/3/22 13:51
 */
public class Solution2 {
    //迭代

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            if (node != null) {
                deque.push(node);
                node = node.left;
            } else {
                node = deque.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
