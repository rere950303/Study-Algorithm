//
// 이진 트리(길 찾기 게임)
// https://programmers.co.kr/learn/courses/30/lessons/42892
// Created by hyungwook on 2021/12/01.
//

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    int[][] answer;
    int index = 0;

    public int[][] solution(int[][] nodeinfo) {
        int length = nodeinfo.length;
        ArrayList<Node> list = new ArrayList<>();
        answer = new int[2][length];

        for (int i = 0; i < length; i++) {
            list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        Collections.sort(list);
        Node root = list.get(0);

        for (int i = 1; i < length; i++) {
            Node node = list.get(i);
            Node tmp = root;

            while (true) {
                if (tmp.r > node.r) {
                    if (tmp.lt == null) {
                        tmp.lt = node;
                        break;
                    }
                    tmp = tmp.lt;
                } else {
                    if (tmp.rt == null) {
                        tmp.rt = node;
                        break;
                    }
                    tmp = tmp.rt;
                }
            }
        }

        preOrder(root);
        index = 0;
        postOrder(root);

        return answer;
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        } else {
            answer[0][index++] = node.i;
            preOrder(node.lt);
            preOrder(node.rt);
        }
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.lt);
            postOrder(node.rt);
            answer[1][index++] = node.i;
        }
    }

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int i;
        Node lt;
        Node rt;

        public Node(int r, int c, int i) {
            this.r = r;
            this.c = c;
            this.i = i;
        }

        @Override
        public int compareTo(Node o) {
            if (this.c != o.c) {
                return o.c - this.c;
            } else {
                return this.r - o.r;
            }
        }
    }
}