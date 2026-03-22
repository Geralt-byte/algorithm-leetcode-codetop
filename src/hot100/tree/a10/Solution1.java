package hot100.tree.a10;

import hot100.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @create 2026/3/22 13:51
 */
public class Solution1 {

    private int count=0;
    private final List<Integer> result=new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        //dfs
        bfs(root,1);
        return result;
    }

    private void bfs(TreeNode root,int deep){
        if(root==null) return;
        if(count<deep){
            result.add(root.val);
            count++;
        }
        bfs(root.right,deep+1);
        bfs(root.left,deep+1);
    }
}
