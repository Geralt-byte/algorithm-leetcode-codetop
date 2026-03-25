package hot100.stack.a4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * @create 2026/3/25 14:56
 */
public class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        //单调递减栈
        int[] result = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                int pop = deque.pop();
                result[pop] = i - pop;
            }
            deque.push(i);
        }
        return result;
    }
}
