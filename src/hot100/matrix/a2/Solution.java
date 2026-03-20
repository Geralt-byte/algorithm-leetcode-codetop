package hot100.matrix.a2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @create 2026/3/21 01:02
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix.length==1&&matrix[0].length==1){
            result.add(matrix[0][0]);
            return result;
        }
        int m=matrix.length,n=matrix[0].length;
        int left=0,right=n-1,top=0,bottom=m-1;
        int sum=m*n;
        while (sum>0){
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
                sum--;
            }
            top++;
            if(sum==0) break;
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
                sum--;
            }
            right--;
            if(sum==0) break;
            for (int col = right; col >= left; col--) {
                result.add(matrix[bottom][col]);
                sum--;
            }
            bottom--;
            if(sum==0) break;
            for (int row = bottom; row >= top; row--) {
                result.add(matrix[row][left]);
                sum--;
            }
            left++;
        }
        return result;
    }
}
//1  2 3  4
//5  6 7  8
//9 10 11 12
