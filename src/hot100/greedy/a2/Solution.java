package hot100.greedy.a2;

/**
 * @author mlei@xjtu
 * @description 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * @create 2026/3/26 15:55
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int index=0;
        while (true){
            //max记录跳一次后，可以到达的最远距离，next维护下一跳的位置
            int max=index,next=index;
            for (int i = 1; i <= nums[index]; i++) {
                //下一跳的位置
                int nextIndex=i+index;
                //记录下一跳可以到达的最远距离，并更新下一跳的位置
                if(nums[nextIndex]+nextIndex>max){
                    max=nums[nextIndex]+nextIndex;
                    next=i+index;
                }
                //可以到达尾部，退出循环
                if(nums[next]+next>=nums.length-1){
                    return true;
                }
            }
            //还是只能到达index说明碰到数值为0的索引，返回false
            if(max==index) return false;
            //将索引位置更新为下一跳
            index=next;
        }
    }
}
