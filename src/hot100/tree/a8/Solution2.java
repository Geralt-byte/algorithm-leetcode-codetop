package hot100.tree.a8;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @create 2026/3/22 13:51
 */
public class Solution2 {
    //中序非递归
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode pre = null;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node != null) {
                if (node.right != null) deque.push(node.right);
                deque.push(node);
                deque.push(null);
                if (node.left != null) deque.push(node.left);
            } else {
                node = deque.pop();
                if (pre != null && node.val <= pre.val) return false;
                pre = node;
            }
        }
        return true;
    }
}
