package hot100.select.a2;

/**
 * @author mlei@xjtu
 * @description 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * @create 2026/3/24 17:39
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //low最后的位置是查找数插入的位置，high的位置是查找数的前一个位置，第一次寻找要找到查找数前一个位置

        //在row方向查找
        int low=0,high=matrix.length-1;
        while (low<=high){
            int mid=low+(high-low+1)/2;
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]>target) high=mid-1;
            else low=mid+1;
        }
        //前一个位置为空，无法查找到
        if(high<0) return false;

        //row确定
        int index=high;
        //在col方向继续查找
        low=0;
        high=matrix[index].length-1;
        while (low<=high){
            int mid=low+(high-low+1)/2;
            if(matrix[index][mid]==target) return true;
            else if(matrix[index][mid]>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}
