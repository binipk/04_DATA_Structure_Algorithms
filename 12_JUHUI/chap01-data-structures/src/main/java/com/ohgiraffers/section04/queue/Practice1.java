package com.ohgiraffers.section04.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice1 {

    public String solution(int n, int k) throws IOException {

        Queue<Integer> q = new LinkedList<Integer>();

        // 큐에 1 ~ n까지의 값 offer(추가하기)
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");
        // 큐의 크기가 1보다 클 때
        while(q.size() > 1) {
            //1부터 k번째 수 전까지 큐의 맨 앞 숫자를 삭제 -> 맨 앞에 추가
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            // k번째 수를 저장
            sb.append(q.poll()).append(", ");
        }
        // while문이 다 돌면 큐에는 원소 하나만 남아있을 것
        // 그렇다면 남은 원소를 다시 저장
        sb.append(q.poll()).append(">");

        return sb.toString();
    }
}
