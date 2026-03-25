package hot100.stack.a5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @create 2026/3/25 14:56
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        //单调栈
        //用来解决寻找数组中第一个比每个元素大或者小的问题模板
        int n = heights.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && heights[i] < heights[deque.peek()]) {
                int pop = deque.pop();
                right[pop] = i;
            }
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            int pop = deque.pop();
            right[pop] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[i] < heights[deque.peek()]) {
                int pop = deque.pop();
                left[pop] = i;
            }
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            int pop = deque.pop();
            left[pop] = -1;
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i]-1;
            max=Math.max(max,width*heights[i]);
        }
        return max;
    }
}
