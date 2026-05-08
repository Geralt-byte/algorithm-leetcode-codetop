package codetop.page05.a19;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @create 2026/5/8 14:15
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                result = nums[i];
            } else {
                if (nums[i] == result) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return result;
    }
}
