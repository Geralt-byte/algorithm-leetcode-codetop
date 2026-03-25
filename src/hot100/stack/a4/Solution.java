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
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //超时
        int[] result = new int[temperatures.length];
        result[result.length - 1] = 0;
        List<Integer> topList = new LinkedList<>();
        topList.add(temperatures.length - 1);
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] == temperatures[i + 1]) {
                result[i] = result[i + 1] == 0 ? result[i + 1] : result[i + 1] + 1;
                topList.set(topList.size() - 1, i);
            } else if (temperatures[i] < temperatures[i + 1]) {
                topList.add(i);
                result[i] = 1;
            } else {
                topList.set(topList.size() - 1, i);
                for (int j = topList.size() - 2; j >= 0; j--) {
                    if (temperatures[topList.get(j)] > temperatures[i]) {
                        result[i] = topList.get(j) - i;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
