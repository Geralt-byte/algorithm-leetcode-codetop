package hot100.mult_dp.a3;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * @create 2026/3/28 23:44
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1, start = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && l > maxLen) {
                    maxLen = l;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
