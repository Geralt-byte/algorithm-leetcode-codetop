package hot100.tree.a7;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 * @create 2026/3/22 13:51
 */
public class Solution {
    //递归
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }

    private TreeNode buildTree(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=left+(right-left+1)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildTree(nums,left,mid-1);
        root.right=buildTree(nums,mid+1,right);
        return root;
    }
}
