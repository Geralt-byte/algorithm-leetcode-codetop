package codetop.page05.a20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * @create 2026/5/8 14:29
 */
public class Solution1 {

    private boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int d = prerequisites[i][0];
            int s = prerequisites[i][1];
            list.get(s).add(d);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < list.size(); i++) {
            if (visited[i] == 0 && valid) {
                dfs(list, visited, i);
                if (!valid) break;
            }
        }
        return valid;
    }

    private void dfs(List<List<Integer>> list, int[] visited, int index) {
        visited[index] = 1;
        for (int i = 0; i < list.get(index).size(); i++) {
            int d = list.get(index).get(i);
            if (visited[d] == 0) {
                dfs(list, visited, d);
                if(!valid) return;
            } else if (visited[d] == 1) {
                valid = false;
                break;
            }
        }
        visited[index] = 2;
    }
}
