package codetop.page01.a9;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * @create 2026/4/13 14:44
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int n = s.length();
        //dp表示以i，j为端点的子串是否回文
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0, maxLen = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= n) break;
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && len > maxLen) {
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
