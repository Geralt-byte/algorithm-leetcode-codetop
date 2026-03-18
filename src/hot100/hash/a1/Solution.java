package hot100.hash.a1;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 * @create 2026/3/18 13:17
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }
            else {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                List<Integer> list = map.get(temp);
                for (Integer integer : list) {
                    if(integer!=i){
                        return new int[]{i,integer};
                    }
                }
            }
        }
        return null;
    }
}
