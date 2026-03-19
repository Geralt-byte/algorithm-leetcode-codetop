package hot100.sub_string.a1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * @create 2026/3/19 14:39
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int result = 0;
        //key=前缀和，value=前缀和出现次数
        Map<Integer, Integer> map = new HashMap<>();
        //前缀和=0，表示数组最开始的前缀和，没有一个元素
        map.put(0,1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //计算所有前缀和
            preSum += nums[i];
            //当前前缀和-k存在于map中，表示从i向前数若干索引，存在一个连续子数组使得数组和为k
            if (map.containsKey(preSum - k)) {
                //value存储的是出现的次数，即为结果数量
                result += map.get(preSum - k);
            }
            //将当前前缀和存储于map中，已存在则次数+1
            map.put(preSum, map.getOrDefault(preSum, 0)+1);
        }
        return result;
    }
}
