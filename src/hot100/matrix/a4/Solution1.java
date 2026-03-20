package hot100.matrix.a4;

/**
 * @author mlei@xjtu
 * @description 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @create 2026/3/21 01:02
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //z字解法
        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;
        if (matrix[0][0] > target) return false;
        int m=matrix.length,n=matrix[0].length;
        //从右上角开始搜索
        int row=0,col=n-1;
        while (row<m&&col>=0){
            if(matrix[row][col]==target) return true;
            //当目标大于元素时，说明以元素为行的所有元素都不符合要求，将row++
            else if(matrix[row][col]<target){
                row++;
            }
            //当目标小于元素时，说明以元素为列的所有元素都不符合要求，将col--

            //以上成立的前提是矩阵两个方向都是递增序列，且搜索从右上角开始
            else col--;
        }
        return false;
    }
}
