package hot100.tree.a12;

import hot100.tree.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @create 2026/3/22 13:51
 */
public class Solution {

    private final Map<Integer, Integer> map= new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        TreeNode node = new TreeNode(preorder[preLeft]);
        int index = map.get(preorder[preLeft]);
        node.left=build(preorder,preLeft+1,preLeft+index-inLeft,inLeft,index-1);
        node.right=build(preorder,preLeft+index-inLeft+1,preRight,index+1,inRight);
        return node;
    }
}
