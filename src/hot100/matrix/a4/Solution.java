package hot100.matrix.a4;

/**
 * @author mlei@xjtu
 * @description 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @create 2026/3/21 01:02
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;
        if (matrix[0][0] > target) return false;
        int m = matrix.length, n = matrix[0].length;
        //查找两个方向上的上界
        int colLim = binarySearch(matrix, target, 0, n - 1, "raw");
        int rawLim = binarySearch(matrix, target, 0, m - 1, "col");
        //返回元素等于target时，直接返回
        if (target == matrix[0][colLim] || target == matrix[rawLim][0]) return true;
        //按列查找
        for (int col = colLim; col >= 0; col--) {
            if(binarySearchCol(matrix, target, 0, rawLim, col)) return true;
        }
        return false;
    }

    //缩短搜索的上界
    public int binarySearch(int[][] matrix, int target, int start, int end, String type) {
        if (type.equals("raw")) {
            while (start <= end) {
                int mid = start + (end - start + 1) / 2;
                if (matrix[0][mid] == target) return mid;
                else if (matrix[0][mid] > target) end = mid - 1;
                else start = mid + 1;
            }
            return end;
        } else {
            while (start <= end) {
                int mid = start + (end - start + 1) / 2;
                if (matrix[mid][0] == target) return mid;
                else if (matrix[mid][0] > target) end = mid - 1;
                else start = mid + 1;
            }
            return end;
        }
    }

    //按列查找
    public boolean binarySearchCol(int[][] matrix, int target, int start, int end, int col) {
        while (start <= end) {
            int mid = start + (end - start + 1) / 2;
            if (matrix[mid][col] == target) return true;
            else if (matrix[mid][col] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
