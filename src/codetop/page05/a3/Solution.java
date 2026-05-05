package codetop.page05.a3;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * @create 2026/5/5 09:57
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        if (root != null) {
            Deque<TreeNode> numDeque = new LinkedList<>();
            Deque<Long> indexDeque = new LinkedList<>();
            numDeque.offer(root);
            indexDeque.offer(1L);
            while (!numDeque.isEmpty()) {
                int width = numDeque.size();
                long left = 0L;
                for (int i = 0; i < width; i++) {
                    TreeNode node = numDeque.poll();
                    long index = indexDeque.poll();
                    if (i == 0) {
                        left = index;
                    }
                    if (i == width - 1) {
                        result = Math.max(result, (int) (index - left + 1));
                    }
                    if (node.left != null) {
                        numDeque.offer(node.left);
                        indexDeque.offer(2 * (index - left));
                    }
                    if (node.right != null) {
                        numDeque.offer(node.right);
                        indexDeque.offer(2 * (index - left) + 1);
                    }
                }
            }
        }
        return result;
    }
}
