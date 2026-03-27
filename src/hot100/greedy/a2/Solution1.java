package hot100.greedy.a2;

/**
 * @author mlei@xjtu
 * @description 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * @create 2026/3/26 15:55
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        //max记录目前可以到达的最远距离
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            //当前的位置无法到达就退出
            if(i<=max){
                //更新可以到达的最远距离
                if(nums[i]+i>max){
                    max=nums[i]+i;
                }
                //可以到达末尾，结束
                if(max>=nums.length-1) return true;
            }
            else break;
        }
        return false;
    }
}
