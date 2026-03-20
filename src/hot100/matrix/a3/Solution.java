package hot100.matrix.a3;

/**
 * @author mlei@xjtu
 * @description 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @create 2026/3/21 01:02
 */
public class Solution {
    public void rotate(int[][] matrix) {
        //先副对角线旋转，在沿横轴方向逆置矩阵
        int n=matrix.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                swap(matrix,i,j,n);
            }
        }
        int top=0,bottom=n-1;
        while (top<bottom){
            for (int i = 0; i < n; i++) {
                int temp=matrix[top][i];
                matrix[top][i]=matrix[bottom][i];
                matrix[bottom][i]=temp;
            }
            top++;
            bottom--;
        }
    }

    private void swap(int[][] matrix,int row,int col,int n){
        int temp=matrix[row][col];
        matrix[row][col]=matrix[n-col-1][n-row-1];
        matrix[n-col-1][n-row-1]=temp;
    }
    //00 22
    //01 12
    //i,j n-j-1,n-i-1
    //1,0 2,1
    //0 2 1 3
}
