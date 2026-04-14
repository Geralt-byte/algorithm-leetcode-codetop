package codetop.page01.a11;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @create 2026/4/14 13:48
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //迭代
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            deque.offer(root);
            while (!deque.isEmpty()) {
                int width = deque.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < width; i++) {
                    TreeNode node = deque.poll();
                    list.add(node.val);
                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                }
                result.add(list);
            }
        }
        return result;
    }
}
