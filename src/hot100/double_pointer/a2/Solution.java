package hot100.double_pointer.a2;

/**
 * @author mlei@xjtu
 * @description 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * @create 2026/3/18 15:32
 */
public class Solution {
    public int maxArea(int[] height) {
        int result=0;
        int i=0,j=height.length-1;
        while (i<j){
            result=Math.max(result,Math.min(height[i],height[j])*(j-i));
            if(height[i]<=height[j]){
                i++;
            }
            else {
                j--;
            }
        }
        return result;
    }
}
