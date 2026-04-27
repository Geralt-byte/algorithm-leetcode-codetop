package codetop.page04.a5;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @create 2026/4/27 09:21
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> dequeLeft = new LinkedList<>();
        Deque<TreeNode> dequeRight = new LinkedList<>();
        dequeLeft.offer(root);
        dequeRight.offer(root);
        while (!dequeLeft.isEmpty()) {
            int width = dequeLeft.size();
            for (int i = 0; i < width; i++) {
                TreeNode left = dequeLeft.poll();
                TreeNode right = dequeRight.poll();
                if (left.left == null && right.right == null) {

                } else if (left.left == null || right.right == null || left.left.val != right.right.val) {
                    return false;
                } else {
                    dequeLeft.offer(left.left);
                    dequeRight.offer(right.right);
                }
                if (left.right == null && right.left == null) {

                } else if (left.right == null || right.left == null || left.right.val != right.left.val) {
                    return false;
                } else {
                    dequeLeft.offer(left.right);
                    dequeRight.offer(right.left);
                }
            }
        }
        return true;
    }
}
