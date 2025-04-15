package com.ohgiraffers.section04.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Practice1 {

    public String solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // 1번부터 n번까지 사람을 줄에 세운다.
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        String result = "<";

        // queue가 비어있지 않을때까지 반복 (사람이 전부 제거되기 전까지)
        while (!queue.isEmpty()) {
            // k-1명은 뒤로 보낸다
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }

            // k번째는 제거
            result += queue.poll();

            // 마지막 사람 아닐 때만 , 추가
            if (!queue.isEmpty()) {
                result += ", ";
            }
        }

        result += ">";
        return result;
    }

}
