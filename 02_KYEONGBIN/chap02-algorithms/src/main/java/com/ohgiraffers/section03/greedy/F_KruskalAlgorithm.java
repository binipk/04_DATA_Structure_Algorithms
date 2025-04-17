package com.ohgiraffers.section03.greedy;

// https://www.acmicpc.net/problem/1197
// 최소 신장 트리 (Minimum Spanning Tree)
// 모든 정점을 연결하면서, 전체 간선의 가중치 합이 가장 작은 트리를 만드는 알고리즘
// 크루스칼 알고리즘을 사용함 (간선을 가중치 기준으로 정렬하고, 사이클이 생기지 않도록 연결)
// Union & Find 자료구조를 사용하여 사이클 여부를 확인함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F_KruskalAlgorithm {

    static int[] parent; // 각 정점의 부모를 저장하는 배열 (Union-Find용)

    // 간선 정보를 저장할 클래스 (도로 하나)
    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        // 생성자: 정점 u와 v를 연결하는 간선, weight는 가중치
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // 가중치를 기준으로 오름차순 정렬하기 위해 정의
            return this.weight - o.weight;
        }
    }

    // 특정 정점 x가 속한 집합(그룹)의 대표(루트)를 찾는 메서드
    static int find(int x) {
        if(parent[x] != x) {
            // 루트를 찾을 때까지 재귀 호출 + 경로 압축
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 두 정점 x와 y를 같은 집합(그룹)으로 합치는 메서드
    static void union(int x, int y) {
        int rootX = find(x); // x의 루트
        int rootY = find(y); // y의 루트

        // 루트가 다르면 (다른 그룹이면) 하나로 합침
        if(rootX != rootY) {
            parent[rootY] = rootX; // y 그룹을 x 그룹에 합침
        }
    }

    // 최소 신장 트리를 구하는 메서드
    public static Long solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점(도시) 수
        int E = Integer.parseInt(st.nextToken()); // 간선(도로) 수

        Edge[] edges = new Edge[E]; // 간선 배열 생성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 정점
            int v = Integer.parseInt(st.nextToken()); // 끝 정점
            int weight = Integer.parseInt(st.nextToken()); // 가중치(비용)
            edges[i] = new Edge(u, v, weight); // 간선 배열에 저장
        }

        // 부모 배열 초기화: 처음엔 자기 자신이 부모
        parent = new int[V + 1];
        for(int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 1. 가중치 오름차순 정렬
        Arrays.sort(edges);

        long totalWeight = 0L; // 전체 가중치 합을 저장할 변수

        // 2. 가중치 작은 간선부터 선택해나가는 작업
        for(Edge edge : edges) {
            // 각각의 정점이 연결되어 있는지 확인
            if (find(edge.u) != find(edge.v)) {
                // 연결이 되어 있지 않다면 정점을 연결
                union(edge.u, edge.v);
                totalWeight += edge.weight; // 연결된 간선의 가중치를 합산
            }
        }

        // 최소 신장 트리의 가중치 합을 리턴
        return totalWeight;
    }

}
