package codetop.page01.a20;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @create 2026/4/16 14:27
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack1 = new LinkedList<>();
            Deque<TreeNode> stack2 = new LinkedList<>();
            stack1.push(root);
            boolean flag = true;
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                if (flag) {
                    flag = false;
                    while (!stack1.isEmpty()) {
                        TreeNode node = stack1.pop();
                        list.add(node.val);
                        if (node.left != null) stack2.push(node.left);
                        if (node.right != null) stack2.push(node.right);
                    }
                } else {
                    flag = true;
                    while (!stack2.isEmpty()) {
                        TreeNode node = stack2.pop();
                        list.add(node.val);
                        if (node.right != null) stack1.push(node.right);
                        if (node.left != null) stack1.push(node.left);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }
}
