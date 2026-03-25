package hot100.map.a1;

/**
 * @author mlei@xjtu
 * @description 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * @create 2026/3/23 14:54
 */
public class Solution {
    //dfs
    private final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int result=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    result++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid,int[][] visited,int row,int col){
        visited[row][col]=1;
        for (int i = 0; i < dir.length; i++) {
            int nextRow=row+dir[i][0];
            int nextCol=col+dir[i][1];
            if(nextRow<0||nextRow>visited.length-1||nextCol<0||nextCol>visited[nextRow].length-1) continue;
            if(visited[nextRow][nextCol]==0&&grid[nextRow][nextCol]=='1'){
                dfs(grid,visited,nextRow,nextCol);
            }
        }
    }
}
