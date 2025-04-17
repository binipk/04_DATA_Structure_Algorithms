package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class A_DFS {

    // 깊이 우선 탐색 (DFS: Depth-First Search)
    // 마치 미로 찾기처럼, 한 방향으로 끝까지 가보는 탐색 방식임

    // 1. 시작점에서 출발해서
    // 2. 갈 수 있는 길이 있으면 계속 깊이 들어감 (한 방향으로 쭉~)
    // 3. 더 이상 갈 수 없으면, 이전 갈림길(분기점)로 돌아가서 다른 길로 탐색함
    // 4. 이 과정을 반복하면서 모든 경로를 탐색함

    // 이 때, 방문한 경로를 기억해두는 데에는
    // → "스택(Stack)"이라는 자료구조를 쓰거나
    // → "재귀함수 호출"을 이용함

    // 핵심 포인트:
    // - 깊이 우선! 한 길로 계속 간다
    // - 막히면 뒤로 돌아와서 다른 길 탐색
    // - 스택 또는 재귀로 구현

    // 웜 바이러스에 걸리게 되는 컴퓨터의 수 구하기 문제
    static int node, edge;       // 컴퓨터 수(노드), 연결 수(간선)
    static int[][] map;          // 컴퓨터 간 연결 정보 (인접 행렬)
    static boolean[] visit;      // 방문한 컴퓨터를 표시하는 배열
    static int count = 0;        // 웜 바이러스에 감염된 컴퓨터 수 (1번 제외)

    public static Integer solution(String input) throws IOException {
        // 입력을 한 줄씩 읽기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new StringReader(input));

        node = Integer.parseInt(br.readLine());  // 첫 줄: 컴퓨터 수
        edge = Integer.parseInt(br.readLine());  // 둘째 줄: 연결된 쌍의 수

        // 연결 정보를 담을 2차원 배열 (노드 번호가 1번부터 시작하므로 +1)
        map = new int[node + 1][node + 1];

        // 방문 여부를 기록할 배열 (중복 방문 방지)
        visit = new boolean[node + 1];

        StringTokenizer st;
        // 간선 수만큼 반복하여 연결된 컴퓨터 정보를 map에 기록
        for (int i = 0; i < edge ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 컴퓨터 a
            int b = Integer.parseInt(st.nextToken()); // 컴퓨터 b

            // 무방향 그래프이므로 a-b, b-a 모두 연결
            map[a][b] = map[b][a] = 1;
        }

        dfsRecursive(1); // 시작하는 인자값 (1)



        return count;
    }

    /***
     * Stack을 활용한 DFS
     * @param start
     */
    private static void dfsStack(int start) {

        Stack<Integer> stack = new Stack<>();
        stack.push(start); // start 값을 stack에 처음 넣어준다.
        visit[start] = true; // 방문배열에 기록

        while (!stack.isEmpty()) {
            int current = stack.pop(); // 더이상 사용 안해서 pop
            for (int i = 1; i <= node; i++) {
                if(map[current][i] == 1 && !visit[i]) {
                    stack.push(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
    }

    /***
     * 재귀 함수로 DFS 알고리즘을 구현한 메서드
     * @param start
     */
    private static void dfsRecursive(int start) {
        // 해당 노드를 방문했으므로 방문 배열에 표기
        visit[start] = true;

        // start  노드의 이웃을 탐색하는 과정
        for (int i = 1; i <= node; i++) {
            // start 정점의 이웃 중 방문하지 않은 이웃을 찾는다.
            if (map[start][i] == 1 && !visit[i]) {
                // 현재 컴퓨터와 연결된 다른 컴퓨터를 발견했으니
                // 감염된 컴퓨터 수(count)를 1 증가시킴
                // 그리고 그 컴퓨터로 이동해서 다시 연결된 컴퓨터들을 찾아봄 (재귀 호출)
                count++;
                dfsRecursive(i);

            }
        }
    }


}
