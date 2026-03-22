package hot100.tree.a9;

import hot100.tree.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
 * @create 2026/3/22 13:51
 */
public class Solution2 {
    //进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
    //使用哈希记录节点数

    private static class MyTree{
        public Map<TreeNode,Integer> countMap;

        public MyTree(TreeNode root) {
            this.countMap = new HashMap<>();
            count(root);
        }

        private int count(TreeNode root){
            if (root==null) return 0;
            int left=count(root.left);
            int right=count(root.right);
            countMap.put(root,1+left+right);
            return 1+left+right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        MyTree myTree = new MyTree(root);
        return getK(root,myTree,k);
    }

    private int getK(TreeNode root,MyTree myTree,int k){
        while (root!=null){
            int count=myTree.countMap.getOrDefault(root.left,0);
            if(k-1>count){
                k=k-count-1;
                root=root.right;
            }
            else if(k-1==count) break;
            else root=root.left;
        }
        return root.val;
    }
}
