package hot100.skill.a3;

import java.util.Random;

/**
 * @author mlei@xjtu
 * @description 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题
 * @create 2026/3/26 19:56
 */
public class Solution {
    public void sortColors(int[] nums) {
        int lenRed = 0, lenWhite = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                if(i>lenRed){
                    swap(nums,lenRed,i);
                    lenRed++;
                    if(nums[i]==1&&i>lenRed+lenWhite-1){
                        swap(nums,lenRed+lenWhite-1,i);
                    }
                }
                else lenRed++;
            }else if(nums[i]==1){
                if(i>lenRed+lenWhite) swap(nums,lenRed+lenWhite,i);
                lenWhite++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
