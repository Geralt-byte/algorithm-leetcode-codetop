package hot100.tree.a8;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @create 2026/3/22 13:51
 */
public class Solution1 {

    private boolean flag = true;
    private TreeNode pre=null;

    public boolean isValidBST(TreeNode root) {
        //中序递归
        inOrder(root);
        return flag;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (pre != null&&root.val <= pre.val){
                flag = false;
                return;
            }
            pre = root;
            inOrder(root.right);
        }
    }
}
