package hot100.tree.a3;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @create 2026/3/22 13:51
 */
public class Solution1 {
    //前序迭代
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque=new LinkedList<>();
        TreeNode p=root;
        while (p!=null||!deque.isEmpty()){
            if(p!=null){
                swap(p);
                deque.push(p);
                p=p.left;
            }else {
                p=deque.pop();
                p=p.right;
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
