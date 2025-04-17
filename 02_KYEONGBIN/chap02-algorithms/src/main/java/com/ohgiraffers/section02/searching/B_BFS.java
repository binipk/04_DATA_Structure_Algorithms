package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_BFS {

    static int M, N, K; // 배추밭의 크기 (가로, 세로) 와 배추 갯수
    static int[][] map; // 배추밭
    static boolean[][] visit; // 배추 찾기를 할 때 방문 했는지 여부를 확인할 배열
    static int count; // 지렁이의 갯수
    static int[] dirX = {0, 0, -1, 1}; // 상, 하, 좌, 우 방향
    static int[] dirY = {-1, 1, 0, 0}; // 상, 하, 좌, 우 방향

    // (x, y) 좌표를 가지는 Node 클래스
    static class Node {
        int x;
        
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // BFS로 문제를 해결하기 위한 Queue
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배추밭 크기 및 배추 갯수 입력
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        K = Integer.parseInt(st.nextToken()); // 배추 갯수

        // 배추밭 배열 초기화
        map = new int[M][N];
        visit = new boolean[M][N];

        // 배추 위치 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1; // 배추가 있는 곳을 1로 표시
        }

        // 배추밭 출력 (디버깅용)
        printMap();

        // 배추 덩어리 개수 세기
        count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) { // 배추가 있고 방문하지 않은 곳
                    bfs(i, j); // BFS로 연결된 배추들 탐색
                    count++; // 한 덩어리가 끝날 때마다 지렁이 1마리 추가
                }
            }
        }

        return count; // 지렁이의 개수 반환
    }

    // BFS 탐색 메서드
    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y)); // 큐에 시작점 넣기
        visit[x][y] = true; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cx = node.x;
            int cy = node.y;

            // 상, 하, 좌, 우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dirX[i];
                int ny = cy + dirY[i];

                // 범위 밖으로 나가지 않도록 체크
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true; // 방문 처리
                        queue.offer(new Node(nx, ny)); // 큐에 새로운 위치 추가
                    }
                }
            }
        }
    }

    // 배추밭 출력 메서드
    private static void printMap() {
        System.out.println("배추밭 모양:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " "); // 1은 배추, 0은 배추 없음
            }
            System.out.println();
        }
    }
}
