package hot100.tree.a3;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @create 2026/3/22 13:51
 */
public class Solution {
    //递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
