package hot100.map.a3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * @create 2026/3/23 16:43
 */
public class Solution1 {
    //dfs拓扑排序
    private boolean valid=true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] group=new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            int d=prerequisite[0];
            int s=prerequisite[1];
            group[s][d]=1;
        }
        int[] visited=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(visited[i]==0&&valid){
                dfs(group,visited,i);
            }
            if(!valid) break;
        }
        return valid;
    }

    private void dfs(int[][] group,int[] visited,int index){
        visited[index]=1;
        for (int i = 0; i < group[index].length; i++) {
            if (group[index][i]!=0) {
                if(visited[i]==0){
                    dfs(group,visited,i);
                    if(!valid) return;
                }else if(visited[i]==1){
                    valid=false;
                    break;
                }
            }
        }
        visited[index]=2;
    }
}
