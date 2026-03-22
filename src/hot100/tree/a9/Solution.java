package hot100.tree.a9;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
 * @create 2026/3/22 13:51
 */
public class Solution {
    private int count=0;
    private int result=0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return result;
    }

    private void inOrder(TreeNode root,int k){
        if(root!=null){
            inOrder(root.left,k);
            count++;
            if(count==k){
                result=root.val;
                return;
            }
            inOrder(root.right,k);
        }
    }
}
