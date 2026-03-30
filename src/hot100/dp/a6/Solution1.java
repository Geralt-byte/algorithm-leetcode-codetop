package hot100.dp.a6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * @create 2026/3/27 17:22
 */
public class Solution1 {
    //dp[i]表示以i为长度的s子串(从头开始)能否被成功拆分
    //状态转移方程    dp[i]=dp[i-len]&&wordDict.contains(s.sub(i-len,i));len为当前单词的长度
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int j=word.length();
                if (i >= j && dp[i - j] && word.equals(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}
