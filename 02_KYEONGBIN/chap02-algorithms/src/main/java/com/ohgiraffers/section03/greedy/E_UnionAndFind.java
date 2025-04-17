package com.ohgiraffers.section03.greedy;

// Union & Find
// 집합 간의 연산을 효율적으로 처리하기 위해 설계된 데이터 구조
// 특히 집합의 합집합(Union)과 특정 원소가 속한 집합을 찾기(Find) 연산을
// 빠르게 처리하는 데 유용함
// 각 원소는 처음에 자신만 포함하는 독립적인 집합을 이루며 시작함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E_UnionAndFind {

    static int[] parent;  // 각 원소가 속한 집합의 대표(부모)를 저장하는 배열

    // 특정 원소가 속한 집합의 대표(루트)를 찾는 메서드
    // 재귀적으로 부모를 따라가며 루트 노드를 찾고, 경로 압축(Path Compression)을 수행함
    static int find(int x) {
        // 자신이 루트가 아니라면, 부모를 따라가며 최상위 루트를 찾음
        // 이때 경로 압축을 위해 부모를 루트로 갱신함
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];  // 루트 노드를 반환
    }

    // 두 원소가 속한 집합을 하나로 합치는 연산
    // 각 원소의 루트를 찾아 하나의 집합으로 연결함
    static void union(int x, int y) {
        int rootX = find(x);  // x의 루트 노드
        int rootY = find(y);  // y의 루트 노드

        // 루트가 다를 경우에만 합침
        // 보통 작은 값을 루트로 삼거나 한 쪽을 기준으로 연결함
        if (rootX != rootY) parent[rootY] = rootX;
    }

    // 주어진 입력 문자열을 바탕으로 유니온 파인드 연산을 수행하고 결과를 반환
    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;

        // 첫 줄에서 학생 수(N)와 친구 관계 수(M)를 입력받음
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 학생 수
        int M = Integer.parseInt(st.nextToken());  // 친구 관계 수

        // parent 배열 초기화
        // 처음에는 각 원소가 자기 자신을 부모로 가짐 (자기 자신이 집합의 루트)
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // M개의 친구 관계 입력을 받아 union 연산 수행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 친구 a
            int b = Integer.parseInt(st.nextToken());  // 친구 b
            union(a, b);  // a와 b를 같은 집합으로 연결

            // union 연산 후 parent 배열 상태 출력 (디버깅용)
            System.out.println("union(" + a + "," + b + ")");
            System.out.println("parent : " + Arrays.toString(parent));
        }

        // 마지막 줄에서 두 학생 x, y가 같은 집합에 속하는지 확인
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());  // 확인할 학생 x
        int y = Integer.parseInt(st.nextToken());  // 확인할 학생 y

        // find로 루트를 찾아 같으면 YES, 다르면 NO 출력
        if (find(x) == find(y)) {
            return "YES";  // 같은 집합에 속함
        } else {
            return "NO";   // 다른 집합에 속함
        }
    }
}
