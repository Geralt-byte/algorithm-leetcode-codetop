package realhw.hw0422.ai.a2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mlei@xjtu
 * @description 小红正在给一套网络安全智能体做离线回放分析。系统会把每个基站在某一时刻采集到的异常流量记录成一个点，
 * 包含它的坐标、时间戳、负载值以及服务用户数。
 * 如果两个基站的曼哈顿距离不超过给定阈值 `dist`，小红就认为它们在空间上可以直接联动。
 * 对任意一个基站，若把它自己以及所有与它直接联动的基站的负载值 `w` 全部加起来，得到的总和不小于 `Wthreshold`，那么这个基站会被标记为一个关键节点。
 * 接下来，小红只关心关键节点之间的异常传播。若两个关键节点本身可以直接联动，并且前者的时间戳严格小于后者，
 * 那么异常流量可以从前者传到后者。若两者时间戳相同，则它们之间不能建立传播方向。
 * 一条传播链需要由若干个关键节点通过上述有向关系依次连接而成，因此它至少要包含一条有效链路。传播链的规模定义为链上所有节点的服务用户数 `Users` 之和。
 * 请你帮助小红计算，在所有可能形成的传播链中，规模最大的那一条能覆盖多少用户。
 * @create 2026/5/5 14:24
 */
public class Main {

    private static long path = 0;
    private static long result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int dist = Integer.parseInt(s[1]);
        int wthreshold = Integer.parseInt(s[2]);
//        int n = 3;
//        int dist = 1;
//        int wthreshold = 100;
        Node[] nodes = new Node[n];
//        build(nodes);
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            nodes[i] = new Node();
            nodes[i].x = Integer.parseInt(line[0]);
            nodes[i].y = Integer.parseInt(line[1]);
            nodes[i].timeStamp = Integer.parseInt(line[2]);
            nodes[i].weight = Integer.parseInt(line[3]);
            nodes[i].users = Integer.parseInt(line[4]);
        }
        Arrays.sort(nodes, (a, b) -> a.timeStamp - b.timeStamp);
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            int temp = nodes[i].weight;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int d = Math.abs(nodes[j].x - nodes[i].x) + Math.abs(nodes[j].y - nodes[i].y);
                    if (d <= dist) {
                        map[i][j] = 1;
                        temp += nodes[j].weight;
                        if (temp >= wthreshold) nodes[i].valid = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i].valid) {
                path = nodes[i].users;
                dfs(map, nodes, i);
            }
        }
        System.out.println(result);
    }

    private static class Node {
        int x;
        int y;
        int timeStamp;
        int weight;
        int users;
        boolean valid;

        Node() {
        }

        Node(int x, int y, int timeStamp, int weight, int users) {
            this.x = x;
            this.y = y;
            this.timeStamp = timeStamp;
            this.weight = weight;
            this.users = users;
            this.valid = false;
        }
    }

    private static void dfs(int[][] map, Node[] nodes, int index) {
        for (int i = 0; i < map.length; i++) {
            if (map[index][i] == 1 && nodes[index].timeStamp < nodes[i].timeStamp && nodes[i].valid) {
                path += nodes[i].users;
                result = Math.max(path, result);
                dfs(map, nodes, i);
                path -= nodes[i].users;
            }
        }
    }

    private static void build(Node[] nodes) {
        String[] strings = new String[3];
        strings[0] = "0 0 5 40 7";
        strings[1] = "1 0 6 40 8";
        strings[2] = "2 0 7 40 9";
        for (int i = 0; i < nodes.length; i++) {
            String[] line = strings[i].split(" ");
            nodes[i] = new Node();
            nodes[i].x = Integer.parseInt(line[0]);
            nodes[i].y = Integer.parseInt(line[1]);
            nodes[i].timeStamp = Integer.parseInt(line[2]);
            nodes[i].weight = Integer.parseInt(line[3]);
            nodes[i].users = Integer.parseInt(line[4]);
        }
    }
}
