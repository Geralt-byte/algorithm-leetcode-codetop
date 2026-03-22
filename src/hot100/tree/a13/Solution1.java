package hot100.tree.a13;

import hot100.tree.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @create 2026/3/22 13:51
 */
public class Solution1 {
    //哈希表
    private int result=0;
    private final Map<Long,Integer> map=new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1);
        dfs(root,targetSum,0);
        return result;
    }

    private void dfs(TreeNode root,long targetSum,long path){
        if(root==null) return;
        path+=root.val;
        result+=map.getOrDefault(path-targetSum,0);
        map.put(path,map.getOrDefault(path,0)+1);
        dfs(root.left,targetSum,path);
        dfs(root.right,targetSum,path);
        map.put(path,map.getOrDefault(path,0)-1);
    }
}
