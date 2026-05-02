package realhw.hw0415.ai.a1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author mlei@xjtu
 * @description 小红目前正在负责一家大型 AI 实验室的推理资源调度工作。
 * 为了提高大语言模型（LLM）的并行推理效率，她需要为当前任务队列中的一系列请求分配 Token 资源（单位：k）。
 * 队列中的每个推理请求都有一个对应的优先级评分。在分配资源时，小红设定了如下调度规则：
 * 1. 优先级评分小于或等于 0 的请求会被视为无效任务或系统预留任务，不参与本次 Token 分配，
 * 即分配到的 Token 数量为 0。
 * 2. 这些无效任务会将整个请求序列切分成若干个由连续有效任务（优先级评分大于 0）构成的子段。
 * 3. 对于每个有效任务子段，段内的每个请求至少要分配 1k 个 Token。
 * 4. 在同一个子段内部，如果某个请求的优先级评分严格高于它左边或右边相邻的任务，
 * 那么它分配到的 Token 数量必须严格多于该相邻任务。
 * 小红希望在完全满足上述规则的前提下，计算出分配给所有任务的 Token 总数最小值是多少。
 * @create 2026/5/3 00:22
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.trim().split(",");
        int[] list = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            list[i] = Integer.parseInt(split[i]);
        }
        int index = 0;
        long result = 0L;
        while (index < list.length) {
            while (index < list.length && list[index] <= 0) {
                index++;
            }
            List<Integer> sub = new ArrayList<>();
            while (index < list.length && list[index] > 0) {
                sub.add(list[index]);
                index++;
            }
            if (!sub.isEmpty()) {
                int[] tokens = new int[sub.size()];
                Arrays.fill(tokens, 1);
                for (int i = 1; i < tokens.length; i++) {
                    if (sub.get(i) > sub.get(i - 1)) {
                        tokens[i] = Math.max(tokens[i], tokens[i - 1] + 1);
                    }
                }
                result += tokens[tokens.length - 1];
                for (int i = tokens.length - 2; i >= 0; i--) {
                    if (sub.get(i) > sub.get(i + 1)) {
                        tokens[i] = Math.max(tokens[i], tokens[i + 1] + 1);
                    }
                    result += tokens[i];
                }
            }
        }
        System.out.println(result);
    }
}
