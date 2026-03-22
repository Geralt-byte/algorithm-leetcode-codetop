package hot100.tree.a1;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @create 2026/3/22 13:51
 */
public class Solution {
    //递归
    private final List<Integer> result=new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            result.add(root.val);
            inorder(root.right);
        }
    }
}
