package hot100.sub_string.a3;

/**
 * @author mlei@xjtu
 * @description 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。
 * 如果没有这样的子串，返回空字符串 ""。
 * 测试用例保证答案唯一。
 * @create 2026/3/19 16:49
 */
public class Solution1 {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        //map记录t中各个字符的个数,window记录窗口中各个字符的个数
        int[] map=new int[128];
        int[] window=new int[128];
        //滑动窗口起始位置，终止位置，最小子串起始位置，t中存在字符种类，窗口中字符数量已满足t中对应字符数量的统计值，最小子串长度
        int start=0,end=0,index=0,need=0,valid=0,minLen=Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
            //第一次出现时计数
            if(map[t.charAt(i)]==1) need++;
        }
        while (end<s.length()){
            //向右扩展滑动窗口
            char endS=s.charAt(end);
            end++;
            //字符出现在t中才有意义
            if(map[endS]>0){
                window[endS]++;
                //当win被增加后等于map时，说明有有一个字符从数量得到了满足，valid++
                if(map[endS]==window[endS]){
                    valid++;
                }
            }
            //当valid==need时，说明滑动窗口已经满足了t的要求，开始尝试缩减窗口
            while (valid==need){
                //当前窗口小于上一次记录窗口时候，更新minLen和index
                if(end-start<minLen){
                    minLen=end-start;
                    index=start;
                }
                //从左侧缩减窗口
                char startS=s.charAt(start);
                start++;
                //字符出现在t中才有意义
                if(map[startS]>0){
                    //当被缩减前map==window时，说明有一个字符即将不满足要求，valid--
                    if(map[startS]==window[startS]){
                        valid--;
                    }
                    window[startS]--;
                }
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(index,index+minLen);
    }
}
