package codetop.page03.a6;

/**
 * @author mlei@xjtu
 * @description 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
 * 左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
 * @create 2026/4/22 09:04
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty()) return 0;
        int[] dp = new int[s.length()];
        int max = dp[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else {
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
