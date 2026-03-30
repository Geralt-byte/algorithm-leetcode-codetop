package hot100.dp.a6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * @create 2026/3/27 17:22
 */
public class Solution {

    private Set<String> set;
    private int[] flag;

    public boolean wordBreak(String s, List<String> wordDict) {
        //回溯+记忆法
        set = new HashSet<>(wordDict);
        flag = new int[s.length()];
        return back_tracking(s, 0);
    }

    private boolean back_tracking(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        if (flag[index] == -1) {
            return false;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (set.contains(substring)) {
                boolean b = back_tracking(s, i + 1);
                if (b) return true;
            }
        }
        flag[index] = -1;
        return false;
    }
}
