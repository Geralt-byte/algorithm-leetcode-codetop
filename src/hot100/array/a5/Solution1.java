package hot100.array.a5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * @create 2026/3/20 22:52
 */
public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        //哈希表法
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                set.add(nums[i]);
            }
        }
        int result=1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!set.contains(i)){
                result=i;
                break;
            }
        }
        return result;
    }
}
