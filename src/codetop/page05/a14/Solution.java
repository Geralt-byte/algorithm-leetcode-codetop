package codetop.page05.a14;

import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * @create 2026/5/7 14:39
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //s中的第i个位置能否被拼接出
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int j = word.length();
                if (i >= j && dp[i - j] && word.equals(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
