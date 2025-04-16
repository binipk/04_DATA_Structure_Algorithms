package com.ohgiraffers.section02.searching;

import java.util.LinkedList;
import java.util.Queue;

/*
* BFS는 먼저 방문한 노드를 기준으로 가장 가까운 노드부터 탐색한다.
* 즉, 시작점에서 출발하여 거리 1짜리 노드를 모두 방문한 후,
* 거리 2짜리 노드를 방문하는 방식으로 진행된다.
* 따라서 어떤 노드에 도달했을 때, 처음 도달한 순간이 곧 최단거리가 도니다.
* DFS는 한 방향으로 깊게 들어간 후, 막다른 길에 도달하면 다시 되돌아오므로
* 최단 경로가 아닌 먼 길을 돌아 도착하는 경우도 생길 수 있다.
* */
public class C_ShortestPath {

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

    static Queue<Node> q = new LinkedList<>();

    public static int solution(String input) {

        return 0;
    }
}
