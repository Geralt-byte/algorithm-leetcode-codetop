package codetop.page02.a3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @create 2026/4/17 13:50
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int count=m*n;
        List<Integer> result=new ArrayList<>();
        while (count>0){
            for (int i = left; i <= right; i++) {
                if(count==0) return result;
                result.add(matrix[top][i]);
                count--;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                if(count==0) return result;
                result.add(matrix[i][right]);
                count--;
            }
            right--;
            for (int i = right; i >= left; i--) {
                if(count==0) return result;
                result.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                if(count==0) return result;
                result.add(matrix[i][left]);
                count--;
            }
            left++;
        }
        return result;
    }
}
