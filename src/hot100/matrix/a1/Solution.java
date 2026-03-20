package hot100.matrix.a1;

/**
 * @author mlei@xjtu
 * @description 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * @create 2026/3/21 00:33
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length==1&&matrix[0].length==1) return;
        //记录左上两个侧边是否需要归0
        boolean flagRow=false,flagCol=false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //为0将元素对应的顶边和左边元素置于0作为标记
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    //遍历在顶边和左边时，说明两个侧边需要归0
                    if(i==0) flagRow=true;
                    if(j==0) flagCol=true;
                }
            }
        }
        //遍历顶边，出现0将对应纵向元素调整为0
        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i]==0){
                setMatrix(matrix,i,"col");
            }
        }
        //遍历左边，出现0将对应横向元素调整为0
        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0]==0){
                setMatrix(matrix,i,"row");
            }
        }
        //调整左边和顶边
        if(flagRow) setMatrix(matrix,0,"row");
        if(flagCol) setMatrix(matrix,0,"col");
    }

    //调整纵向或横向的元素为0
    private void setMatrix(int[][] matrix,int index,String type){
        if(type.equals("row")){
            for (int col = 1; col < matrix[index].length; col++) {
                matrix[index][col]=0;
            }
        }
        else {
            for (int row = 1; row < matrix.length; row++) {
                matrix[row][index]=0;
            }
        }
    }
}
