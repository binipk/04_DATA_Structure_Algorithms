package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D_DFSBFS {
    static int node, edge, start;
    static int [][] map;
    static boolean[]visit;
    static StringBuilder sb;
    static Queue<Integer> q = new LinkedList<>();
    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        map = new int[node + 1][node + 1];
        visit = new boolean[node + 1];

        for (int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        sb = new StringBuilder(); // 거쳐가는 모든 내용을 기록
        dfs(start);

        sb.append("\n");

        /* 위의 호출에서 사용된 방문 배열을 reset */
        visit = new boolean[node + 1];

        bfs(start);

        System.out.println(sb.toString());
        return sb.toString();
    }

    private static void bfs(int start) {
        visit[start] = true;
        q.offer(start);

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");

            for (int i = 1; i <= node ; i++) {
                if(map[start][i] == 1 &&  !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i <= node; i++) {
            if(map[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
