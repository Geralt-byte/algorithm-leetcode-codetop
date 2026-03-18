package hot100.hash.a3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @create 2026/3/18 14:37
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max=Integer.MIN_VALUE;
        for (Integer i : set) {
            if(!set.contains(i-1)){
                int count=1;
                int num=i;
                while (set.contains(num+1)){
                    num++;
                    count++;
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }
}
