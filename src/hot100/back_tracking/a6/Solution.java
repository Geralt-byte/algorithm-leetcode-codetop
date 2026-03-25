package hot100.back_tracking.a6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @create 2026/3/23 23:29
 */
public class Solution {
    //dfs
    //类似于孤岛问题解法
    private final int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private boolean valid=false;

    public boolean exist(char[][] board, String word) {
        if(word.length()>board.length*board[0].length) return false;
        List<int[]> startList=new ArrayList<>();
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==c){
                    startList.add(new int[]{i,j});
                }
            }
        }
        int[][] flag=new int[board.length][board[0].length];
        for (int[] i : startList) {
            dfs(board,flag,i[0],i[1],word,0);
            if(valid) return true;
        }
        return false;
    }

    private void dfs(char[][] board,int[][] flag,int row,int col,String word,int index){
        flag[row][col]=1;
        if(index==word.length()-1){
            valid=true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextRow=dir[i][0]+row;
            int nextCol=dir[i][1]+col;
            if(nextRow<0||nextRow>board.length-1||nextCol<0||nextCol>board[nextRow].length-1) continue;
            if(index<word.length()-1&&flag[nextRow][nextCol]==0&&word.charAt(index+1)==board[nextRow][nextCol]){
                dfs(board,flag,nextRow,nextCol,word,index+1);
            }
        }
        flag[row][col]=0;
    }
}

