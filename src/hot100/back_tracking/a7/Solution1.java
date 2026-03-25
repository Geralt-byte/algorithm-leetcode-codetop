package hot100.back_tracking.a7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * @create 2026/3/23 23:29
 */
public class Solution1 {
    //dp判断回文
    private final List<List<String>> result = new ArrayList<>();
    private final List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                dp[i][i + len] = s.charAt(i) == s.charAt(i + len) && dp[i + 1][i + len - 1];
            }
        }
        back_tracking(s, dp, 0);
        return result;
    }

    private void back_tracking(String s, boolean[][] dp, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                path.add(s.substring(start, i + 1));
                back_tracking(s, dp, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}

