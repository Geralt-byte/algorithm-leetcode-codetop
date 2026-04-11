package hot100.hash.a3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @create 2026/3/18 14:37
 */
public class Solution1 {
    public int longestConsecutive(int[] nums) {
        //2刷1
        //用set去重后，从每个序列的开头进行统计
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        int result = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                count = 1;
                while (set.contains(i + 1)) {
                    count++;
                    i++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
