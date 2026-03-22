package hot100.tree.a3;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @create 2026/3/22 13:51
 */
public class Solution2 {
    //bfs
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int width=deque.size();
            for (int i = 0; i < width; i++) {
                TreeNode node=deque.poll();
                swap(node);
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
        }
        return root;
    }

    private void swap(TreeNode root){
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}
