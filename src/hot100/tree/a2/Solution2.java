package hot100.tree.a2;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @create 2026/3/22 13:51
 */
public class Solution2 {
    //dfs

    private int maxDepth=0;

    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return maxDepth;
    }

    private void dfs(TreeNode root,int depth){
        if(root==null){
            maxDepth=Math.max(maxDepth,depth);
            return;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
