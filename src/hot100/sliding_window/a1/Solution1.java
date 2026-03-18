package hot100.sliding_window.a1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * @create 2026/3/18 17:21
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口法
        if(s.length()<2) return s.length();
        int result=1;
        //使用哈希表来判断元素是否在子串中出现过
        Set<Character> set=new HashSet<>();
        int left=0,right=1,length=0;
        while (left<s.length()){
            //左指针每轮循环移除一个元素，以移除后的第一个元素作为子串的起始位置
            if(left!=0){
                set.remove(s.charAt(left-1));
                length--;
            }else {
                set.add(s.charAt(left));
                length++;
            }
            left++;
            //右指针寻找以左指针每轮起始位置为起点的最大子串长度，右指针不需要回溯，因为每轮缩短一个位置，新的子串到右指针之间必然也是一个不重复子串
            //直接从右指针上轮的位置开始寻找即可
            while (right<s.length()&&!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                length++;
                right++;
            }
            result=Math.max(length,result);
            //当右指针遍历完，可以提前退出循环
            if(right==s.length()) break;
        }
        return result;
    }
}
