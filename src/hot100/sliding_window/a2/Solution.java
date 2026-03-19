package hot100.sliding_window.a2;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * @create 2026/3/19 13:41
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //滑动窗口
        List<Integer> result=new ArrayList<>();
        if(s.length()<p.length()) return result;
        int start=0,end=p.length()-1;
        //数组维护滑动窗口中各个元素出现的次数
        int[] countWindow=new int[26];
        int[] countP=new int[26];
        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i)-'a']+=1;
        }
        for (int i = start; i <= end; i++) {
            countWindow[s.charAt(i)-'a']+=1;
        }
        while (end<s.length()){
            //Arrays进行深度数组比较
            if(Arrays.equals(countP,countWindow)){
                result.add(start);
            }
            countWindow[s.charAt(start)-'a']-=1;
            if (end<s.length()-1) {
                countWindow[s.charAt(end+1)-'a']+=1;
            }
            start++;
            end++;
        }
        return result;
    }
}
