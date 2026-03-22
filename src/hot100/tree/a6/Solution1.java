package hot100.tree.a6;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @create 2026/3/22 13:51
 */
public class Solution1 {
    //dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        dfs(root,result,1);
        return result;
    }

    private void dfs(TreeNode root,List<List<Integer>> result,int deep){
        if(root==null) return;
        if(result.size()<deep){
            result.add(new ArrayList<>());
        }
        result.get(deep-1).add(root.val);
        dfs(root.left,result,deep+1);
        dfs(root.right,result,deep+1);
    }
}
