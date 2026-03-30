package hot100.mult_dp.a5;

/**
 * @author mlei@xjtu
 * @description 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * @create 2026/3/30 17:28
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int num1 = dp[i - 1][j] + 1;
                int num2 = dp[i][j - 1] + 1;
                int num3 = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) num3++;
                dp[i][j] = Math.min(num1, Math.min(num2, num3));
            }
        }
        return dp[len1][len2];
    }
}
