package hot100.back_tracking.a2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @create 2026/3/23 23:29
 */
public class Solution {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        back_tracking(nums, 0);
        return result;
    }

    private void back_tracking(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            back_tracking(nums, i+1);
            path.remove(path.size() - 1);
        }
    }
}
