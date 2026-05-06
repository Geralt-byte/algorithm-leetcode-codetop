package codetop.page05.a8;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * @create 2026/5/6 11:13
 */
public class Solution {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root!=null){
            path.add(root.val);
            dfs(root, targetSum, root.val);
        }
        return result;
    }

    private void dfs(TreeNode root, int targetSum, int preSum) {
        if (root != null) {
            if (root.left == null && root.right == null && preSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            if (root.left != null) {
                path.add(root.left.val);
                dfs(root.left, targetSum, preSum + root.left.val);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                path.add(root.right.val);
                dfs(root.right, targetSum, preSum + root.right.val);
                path.remove(path.size() - 1);
            }
        }
    }
}
