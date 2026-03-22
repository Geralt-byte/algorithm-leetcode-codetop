package hot100.tree.a4;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @create 2026/3/22 13:51
 */
public class Solution1 {
    //迭代
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return orderTree(root.left,root.right);
    }

    private boolean orderTree(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1==null||node2==null||node1.val!=node2.val) return false;
        return orderTree(node1.left,node2.right)&&orderTree(node1.right,node2.left);
    }
}
