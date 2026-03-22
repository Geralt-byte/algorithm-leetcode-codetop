package hot100.tree.a11;

import hot100.tree.pojo.TreeNode;

/**
 * @author mlei@xjtu
 * @description 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * @create 2026/3/22 13:51
 */
public class Solution {
    //后序遍历为左右中，改造顺序为右左中，再使用头插法插入即可
    private final TreeNode dummyNode=new TreeNode();

    public void flatten(TreeNode root) {
        postOrder(root);
    }

    private void postOrder(TreeNode root){
        if (root!=null){
            postOrder(root.right);
            postOrder(root.left);
            root.right=dummyNode.right;
            root.left=null;
            dummyNode.right=root;
        }
    }
}
