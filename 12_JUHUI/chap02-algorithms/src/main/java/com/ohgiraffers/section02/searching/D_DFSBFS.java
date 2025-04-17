package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D_DFSBFS {

    static int node, edge, start;
    static int[][] map;
    static boolean[] visit;
    static StringBuilder sb;
    static Queue<Integer> q = new LinkedList<>();


    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        map = new int[node+1][node+1];
        visit = new boolean[node+1];

        for(int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        sb = new StringBuilder(); // 거쳐가는 모든 내용을 기록하는 용도

        dfs(start);

        sb.append('\n');

        /* 위의 호출에서 사용된 방문 배열을 reset 해주는 작업이 꼭 필요. reset을 재사용하는 것이니까*/
        visit = new boolean[node + 1];

        bfs(start);

        return sb.toString();
    }

    static void bfs(int start) {
        q.offer(start);
        visit[start] = true; // 방문한 위치에 콕 짚어줌.

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");

            for(int i = 1; i <= node; i++) {
                if(map[start][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    static void dfs(int start) {

        visit[start] = true; // 도착했음.
        sb.append(start).append(" ");

        for(int i = 1; i <= node; i++) {
            if(map[start][i] == 1 && !visit[i]) {
                dfs(i); // 재귀시키기
            }
        }

    }

}
