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
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //bfs
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int width=deque.size();
            for (int i = 0; i < width; i++) {
                TreeNode node = deque.poll();
                if(i==0){
                    result.add(node.val);
                }
                if(node.right!=null) deque.offer(node.right);
                if(node.left!=null) deque.offer(node.left);
            }
        }
        return result;
    }
}
