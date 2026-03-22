package hot100.tree.a4;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @create 2026/3/22 13:51
 */
public class Solution {
    //迭代
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()){
            TreeNode left=deque.pollFirst();
            TreeNode right=deque.pollLast();
            if(left==null&&right==null) continue;
            if(left==null||right==null||left.val!=right.val) return false;
            deque.offerFirst(left.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
            deque.offerLast(right.left);
        }
        return true;
    }
}
