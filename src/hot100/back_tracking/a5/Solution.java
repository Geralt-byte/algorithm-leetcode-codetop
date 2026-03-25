package hot100.back_tracking.a5;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @create 2026/3/23 23:29
 */
public class Solution {

    private final List<String> result = new ArrayList<>();
    private final StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        back_tracking(n, 0, 0);
        return result;
    }

    private void back_tracking(int length, int leftCount, int rightCount) {
        if (sb.length() == length * 2) {
            result.add(sb.toString());
            return;
        }
        if (leftCount < length) {
            sb.append('(');
            back_tracking(length, leftCount+1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightCount < leftCount) {
            sb.append(')');
            back_tracking(length, leftCount, rightCount+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

