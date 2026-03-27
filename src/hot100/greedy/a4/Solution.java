package hot100.greedy.a4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * @create 2026/3/26 15:55
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map=new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)-'a']=i;
        }
        List<Integer> result=new ArrayList<>();
        int start=0,end=0;
        for (int i = 0; i < s.length(); i++) {
            end=Math.max(end,map[s.charAt(i)-'a']);
            if(i==end){
                result.add(end-start+1);
                end++;
                start=end;
            }
        }
        return result;
    }
}
