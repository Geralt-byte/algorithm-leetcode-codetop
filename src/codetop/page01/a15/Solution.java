package codetop.page01.a15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @create 2026/4/14 15:23
 */
public class Solution {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private boolean[] flag;

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        flag = new boolean[nums.length];
        back_tracking(nums);
        return result;
    }

    private void back_tracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                path.add(nums[i]);
                back_tracking(nums);
                flag[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
