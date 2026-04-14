package codetop.page01.a11;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @create 2026/4/14 13:48
 */
public class Solution1 {

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //递归
        dfs(root, 1);
        return result;
    }

    private void dfs(TreeNode root, int deep) {
        if (root != null) {
            if (result.size() < deep) {
                ArrayList<Integer> list = new ArrayList<>();
                result.add(list);
            }
            result.get(deep-1).add(root.val);
            if (root.left != null) dfs(root.left, deep + 1);
            if (root.right != null) dfs(root.right, deep + 1);
        }
    }
}
