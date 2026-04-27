package codetop.page04.a2;

import hot100.tree.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * @create 2026/4/27 07:23
 */
public class Solution2 {
    public int sumNumbers(TreeNode root) {
        int result=0;
        if(root!=null){
            Deque<TreeNode> deque=new LinkedList<>();
            deque.push(root);
            while (!deque.isEmpty()){
                int width=deque.size();
                for (int i = 0; i < width; i++) {
                    TreeNode node = deque.pop();
                    if(node.left==null&&node.right==null){
                        result+=node.val;
                    }else {
                        if(node.left!=null){
                            node.left.val+=node.val*10;
                            deque.push(node.left);
                        }
                        if(node.right!=null){
                            node.right.val+=node.val*10;
                            deque.push(node.right);
                        }
                    }
                }
            }
        }
        return result;
    }
}
