package codetop.page03.a2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @create 2026/4/21 08:48
 */
public class Solution {

    private final List<String> result = new ArrayList<>();
    private final StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        back_tracking(n, 0, 0);
        return result;
    }

    private void back_tracking(int n, int leftCount, int rightCount) {
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }
        if (leftCount < n) {
            sb.append('(');
            back_tracking(n, leftCount + 1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightCount < leftCount) {
            sb.append(')');
            back_tracking(n, leftCount, rightCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
