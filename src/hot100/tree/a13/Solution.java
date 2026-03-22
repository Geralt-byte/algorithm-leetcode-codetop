package hot100.tree.a13;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @create 2026/3/22 13:51
 */
public class Solution {
    //前序遍历+dfs

    private int result=0;

    public int pathSum(TreeNode root, int targetSum) {
        preOrder(root,targetSum);
        return result;
    }

    private void preOrder(TreeNode root,long targetSum){
        if(root!=null){
            dfs(root,targetSum,0);
            preOrder(root.left,targetSum);
            preOrder(root.right,targetSum);
        }
    }

    private void dfs(TreeNode root,long targetSum,long path){
        if(root==null) return ;
        if(path+root.val==targetSum) result++;
        dfs(root.left,targetSum,path+root.val);
        dfs(root.right,targetSum,path+root.val);
    }
}
