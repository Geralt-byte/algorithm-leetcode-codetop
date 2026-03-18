package hot100.sliding_window.a1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * @create 2026/3/18 17:21
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //时间过长，主要原因是使用了map和右指针回溯过多
        if(s.length()<2) return s.length();
        Map<Character,Integer> map=new HashMap<>();
        int result=1;
        int left=0;
        while (left<s.length()){
            int length=0;
            for (int j = left; j < s.length(); j++) {
                if(!map.containsKey(s.charAt(j))){
                    length++;
                    map.put(s.charAt(j),j);
                    if(j==s.length()-1) return Math.max(result,length);
                }
                else {
                    result=Math.max(result,length);
                    left=map.get(s.charAt(j))+1;
                    map.clear();
                    if(left==s.length()-1) return result;
                    break;
                }
            }
        }
        return result;
    }
}
