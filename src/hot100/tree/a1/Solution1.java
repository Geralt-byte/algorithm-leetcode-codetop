package hot100.tree.a1;

import hot100.tree.pojo.TreeNode;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @create 2026/3/22 13:51
 */
public class Solution1 {
    //空指针标记法

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode temp=deque.pop();
            if(temp!=null){
                if(temp.right!=null) deque.push(temp.right);
                deque.push(temp);
                deque.push(null);
                if(temp.left!=null) deque.push(temp.left);
            }
            else {
                temp = deque.pop();
                result.add(temp.val);
            }
        }
        return result;
    }
}
