package codetop.page04.a7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * @create 2026/4/29 09:19
 */
public class Solution {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        back_tracking(candidates, target, 0);
        return result;
    }

    private void back_tracking(int[] candidates, int target, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                sum += candidates[i];
                path.add(candidates[i]);
                //可以重复选取数字，递归时i不加1
                back_tracking(candidates, target, i);
                path.remove(path.size() - 1);
                sum -= candidates[i];
            } else break;
        }
    }
}
