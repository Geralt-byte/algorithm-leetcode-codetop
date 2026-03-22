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
public class Solution {
    public boolean isValidBST(TreeNode root) {
        //递归
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }
        if(root.val<=min||root.val>=max){
            return false;
        }
        return dfs(root.left,min,root.val)&&dfs(root.right,root.val,max);
    }
}
