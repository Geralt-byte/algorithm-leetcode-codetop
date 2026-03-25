package hot100.back_tracking.a1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @create 2026/3/23 23:29
 */
public class Solution {
    private final List<List<Integer>> result=new ArrayList<>();
    private final List<Integer> path=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        boolean[] flags=new boolean[nums.length];
        back_tracking(nums,flags);
        return result;
    }

    private void back_tracking(int[] nums,boolean[] flags){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!flags[i]){
                path.add(nums[i]);
                flags[i]=true;
                back_tracking(nums,flags);
                flags[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
