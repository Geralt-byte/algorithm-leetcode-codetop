package hot100.double_pointer.a3;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * @create 2026/3/18 15:59
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //时间过长
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            } else {
                int target = -nums[i];
                Set<Integer> set = new HashSet<>();
                for (int j = i + 1; j < nums.length; j++) {
                    if (set.contains(target - nums[j])) {
                        List<Integer> list = new ArrayList<>();
                        Collections.addAll(list, nums[i], target - nums[j], nums[j]);
                        result.add(list);
                    } else {
                        set.add(nums[j]);
                    }
                }
            }
        }
        return result.stream().toList();
    }
}
