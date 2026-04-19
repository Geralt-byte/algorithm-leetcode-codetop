package codetop.page02.a10;

/**
 * @author mlei@xjtu
 * @description 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * @create 2026/4/18 11:23
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty() && !word2.isEmpty()) return word2.length();
        if (word2.isEmpty() && !word1.isEmpty()) return word1.length();
        int len1 = word1.length(), len2 = word2.length();
        //dp[i][j]表示字符串1的前i个字符和字符串2的前j个字符的编辑距离。
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int num1 = dp[i - 1][j] + 1;
                int num2 = dp[i][j - 1] + 1;
                int num3 = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) num3++;
                dp[i][j] = Math.min(num1, Math.min(num2, num3));
            }
        }
        return dp[len1][len2];
    }
}
