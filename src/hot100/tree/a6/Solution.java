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
public class Solution {
    //bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root!=null) {
            Deque<TreeNode> deque=new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()){
                int width=deque.size();
                List<Integer> list=new ArrayList<>();
                for (int i = 0; i < width; i++) {
                    TreeNode node = deque.poll();
                    list.add(node.val);
                    if(node.left!=null) deque.offer(node.left);
                    if(node.right!=null) deque.offer(node.right);
                }
                result.add(list);
            }
        }
        return result;
    }
}
