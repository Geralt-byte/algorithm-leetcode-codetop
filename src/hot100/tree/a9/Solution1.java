package hot100.tree.a9;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
 * @create 2026/3/22 13:51
 */
public class Solution1 {
    //中序非递归
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode p = root;
        int count = 0, result = 0;
        while (p != null || !deque.isEmpty()) {
            if (p != null) {
                deque.push(p);
                p = p.left;
            } else {
                p = deque.pop();
                count++;
                if (count == k) {
                    result = p.val;
                    break;
                }
                p = p.right;
            }
        }
        return result;
    }
}
