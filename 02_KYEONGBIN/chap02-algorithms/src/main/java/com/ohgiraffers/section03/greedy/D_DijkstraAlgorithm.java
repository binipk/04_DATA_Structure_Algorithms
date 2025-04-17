package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D_DijkstraAlgorithm {

    // ✅ 다익스트라 알고리즘:
    // 양의 가중치를 가진 그래프에서 하나의 정점으로부터 다른 모든 정점까지의 최단 거리 계산

    static int n, m, start; // n: 정점 수, m: 간선 수, start: 시작 정점
    static int[] dis;       // dis[i]: 시작점에서 i번 정점까지의 최단 거리

    // ✅ 간선을 표현하는 클래스
    static class Edge implements Comparable<Edge> {
        int var;   // 연결된 정점 번호
        int cost;  // 가중치

        Edge(int var, int cost) {
            this.var = var;
            this.cost = cost;
        }

        // 가중치 기준 오름차순 정렬을 위한 compareTo 오버라이드
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력: 정점 수, 간선 수, 시작 정점
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 그래프 초기화 (0번 인덱스는 사용 안 함)
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 거리 배열 초기화 (무한대 값으로)
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        // 간선 정보 입력 (a: 시작 정점, b: 도착 정점, c: 가중치)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        // ✅ 우선순위 큐 (가중치가 작은 간선이 먼저 나옴)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));  // 시작 정점부터 시작
        dis[start] = 0;

        // ✅ 다익스트라 핵심 반복
        while (!pq.isEmpty()) {
            Edge temp = pq.poll();
            int now = temp.var;       // 현재 정점
            int nowCost = temp.cost;  // 현재까지의 비용

            // 더 짧은 경로가 이미 저장되어 있으면 무시
            if (nowCost > dis[now]) continue;

            // 현재 정점에서 연결된 이웃들 확인
            for (Edge edge : graph.get(now)) {
                int next = edge.var;
                int nextCost = nowCost + edge.cost;

                // 더 짧은 경로 발견 시 갱신
                if (dis[next] > nextCost) {
                    dis[next] = nextCost;
                    pq.offer(new Edge(next, nextCost));
                }
            }
        }

        // ✅ 출력 포맷 구성
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < dis.length; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                sb.append(dis[i]); // 최단 거리 출력
            } else {
                sb.append("impossible"); // 도달할 수 없는 경우
            }
            sb.append(" ");
        }

        System.out.println("Debugging " + sb.toString());
        return sb.toString().trim();
    }
}
