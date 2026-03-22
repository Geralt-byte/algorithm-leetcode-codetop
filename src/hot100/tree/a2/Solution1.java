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
public class Solution1 {
    //bfs
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        int maxDepth=0;
        while (!deque.isEmpty()){
            maxDepth++;
            int width=deque.size();
            for (int i = 0; i < width; i++) {
                TreeNode temp=deque.poll();
                if(temp.left!=null) deque.offer(temp.left);
                if(temp.right!=null) deque.offer(temp.right);
            }
        }
        return maxDepth;
    }
}
