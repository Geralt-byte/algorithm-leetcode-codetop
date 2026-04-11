package codetop.page01.a1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * @create 2026/4/11 17:46
 */
public class Solution {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //小于2的长度不需要判断
        if(s.length()<2) return s.length();
        //去重
        Set<Character> set=new HashSet<>();
        int left=0,right=1,length=0,result=0;
        //每轮循环选一个起始点
        while (left<s.length()){
            //每轮移除一个左边的元素
            if(left==0){
                set.add(s.charAt(left));
                length++;
            }else {
                set.remove(s.charAt(left-1));
                length--;
            }
            left++;
            //从右边增加元素直到有重复为止，因此可以保证下一轮去除一个元素后依然是不重复子串，从right上轮的位置继续判断即可
            while (right<s.length()&&!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                length++;
            }
            result= Math.max(result,length);
            if(right==s.length()) break;
        }
        return result;
    }
}
