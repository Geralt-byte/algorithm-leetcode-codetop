package hot100.back_tracking.a7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * @create 2026/3/23 23:29
 */
public class Solution {

    private final List<List<String>> result = new ArrayList<>();
    private final List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        back_tracking(s,0);
        return result;
    }

    private void back_tracking(String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (judgeString(s, start, i)) {
                path.add(s.substring(start, i + 1));
                back_tracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean judgeString(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

