//
// 원더랜드(프림)
//
// Created by hyungwook on 2021/10/17.
//

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Road>> list = new ArrayList<>();
        PriorityQueue<Road> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        int answer = 0;

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<Road>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            list.get(a).add(new Road(b, cost));
            list.get(b).add(new Road(a, cost));
        }

        queue.add(new Road(1, 0));

        while (!queue.isEmpty()) {
            Road poll = queue.poll();
            if (!check[poll.node]) {
                check[poll.node] = true;
                answer += poll.cost;
            }
            for (Road road : list.get(poll.node)) {
                if (!check[road.node]) {
                    queue.add(road);
                }
            }
        }

        System.out.println(answer);
    }

    static class Road implements Comparable<Road> {
        int node;
        int cost;

        public Road(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }
}