package hot100.skill.a2;

import java.util.Random;

/**
 * @author mlei@xjtu
 * @description 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @create 2026/3/26 19:56
 */
public class Solution {
    public int majorityElement(int[] nums) {
        //随机抽样
        Random random = new Random();
        int count, num;
        while (true) {
            int index = random.nextInt(nums.length);
            num = nums[index];
            count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num) count++;
            }
            if (count > nums.length / 2) break;
        }
        return num;
    }
}
