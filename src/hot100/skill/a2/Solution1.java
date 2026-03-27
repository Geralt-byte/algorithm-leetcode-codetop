package hot100.skill.a2;

import java.util.Random;

/**
 * @author mlei@xjtu
 * @description 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @create 2026/3/26 19:56
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        //擂台
        int result=nums[0];
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if(count==0){
                result =nums[i];
                count++;
            }else {
                if(result==nums[i]){
                    count++;
                }else count--;
            }
        }
        return result;
    }
}
