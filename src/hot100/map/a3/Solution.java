package hot100.map.a3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
public class Solution {
    //拓扑排序bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接表
        List<List<Integer>> group=new ArrayList<>();
        //建立表节点
        for (int i = 0; i < numCourses; i++) {
            group.add(new ArrayList<>());
        }
        //入度数组
        int[] indegrees=new int[numCourses];
        //遍历队列
        Deque<Integer> deque=new LinkedList<>();
        //初始化邻接表，统计入度
        for (int[] prerequisite : prerequisites) {
            int d = prerequisite[0];
            int s = prerequisite[1];
            group.get(s).add(d);
            indegrees[d]++;
        }
        //入度为0入队
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i]==0){
                deque.offer(i);
            }
        }
        //bfs，将下一个节点的入度-1，为0入队
        while (!deque.isEmpty()){
            int poll = deque.poll();
            for (int i = 0; i < group.get(poll).size(); i++) {
                int next = group.get(poll).get(i);
                indegrees[next]--;
                if(indegrees[next]==0) deque.offer(next);
            }
        }
        //有环返回false
        for (int indegree : indegrees) {
            if (indegree != 0) {
                return false;
            }
        }
        return true;
    }
}
