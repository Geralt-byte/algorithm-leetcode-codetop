package codetop.page05.a8;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * @create 2026/5/6 11:13
 */
public class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> nodeDeque = new ArrayDeque<>();
            Deque<List<Integer>> pathDeque = new ArrayDeque<>();
            nodeDeque.offer(root);
            List<Integer> list = new ArrayList<>();
            pathDeque.offer(list);
            while (!nodeDeque.isEmpty()) {
                int width = nodeDeque.size();
                for (int i = 0; i < width; i++) {
                    TreeNode node = nodeDeque.poll();
                    List<Integer> path = pathDeque.poll();
                    path.add(node.val);
                    if (node.left == null && node.right == null) {
                        int sum = 0;
                        for (Integer integer : path) {
                            sum += integer;
                        }
                        if (sum == targetSum) {
                            result.add(new ArrayList<>(path));
                        }
                    }
                    if (node.left != null) {
                        nodeDeque.offer(node.left);
                        pathDeque.offer(new ArrayList<>(path));
                    }
                    if (node.right != null) {
                        nodeDeque.offer(node.right);
                        pathDeque.offer(new ArrayList<>(path));
                    }
                }
            }
        }
        return result;
    }
}
