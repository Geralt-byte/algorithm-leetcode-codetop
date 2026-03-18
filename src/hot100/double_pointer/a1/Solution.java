package hot100.double_pointer.a1;

/**
 * @author mlei@xjtu
 * @description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @create 2026/3/18 15:01
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                count++;
            }
            else  {
                nums[i-count]=nums[i];
                if(count!=0) nums[i]=0;
            }
        }
    }
}
