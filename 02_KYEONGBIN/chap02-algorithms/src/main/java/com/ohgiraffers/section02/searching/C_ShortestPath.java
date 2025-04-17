package com.ohgiraffers.section02.searching;

import java.util.LinkedList;
import java.util.Queue;

public class C_ShortestPath {

// BFS(너비 우선 탐색)는 먼저 가까운 곳부터 차례대로 탐색하는 방법이에요.
// 예를 들어, 시작점에서 1칸 떨어진 곳들을 먼저 모두 살펴보고,
// 그 다음에 2칸, 3칸 떨어진 곳들을 차례로 살펴봐요.
// 그래서 어떤 위치에 처음 도착했을 때, 그때가 가장 빠르게 도착한 순간이에요 (= 최단 거리).
//
// 반면, DFS(깊이 우선 탐색)는 한 방향으로 계속 깊이 들어가요.
// 그러다 막히면 다시 되돌아가서 다른 방향을 탐색해요.
// 그래서 가끔은 돌아가는 먼 길로 도착할 수도 있어서,
// 꼭 최단 거리를 찾는 건 아니에요.

    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Node> queue = new LinkedList<>();

    public static int solution(String input) {

        return 0;
    }



















}
