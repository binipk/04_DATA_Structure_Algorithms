package com.ohgiraffers.section04.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 백준 1158 - 요세푸스 문제 */
public class Practice1 {
//    public static void main(String[] args) {
//        System.out.println(solution(7, 3));
//    }
    public String solution(int n, int k) {
        // 7 3
        // <3, 6, 2, 7, 5, 1, 4>
        // 1, 2, 3, 4, 5, 6, 7

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        List<Integer> list = new ArrayList<>();

        int cnt = 0;
        while(!queue.isEmpty()) {
            int next = queue.poll();
            cnt++;
            if (cnt % k == 0) {
                // 리스트에 값 넣기
                list.add(next);
            } else {
                // 다시 queue 뒤로 넣기
                queue.offer(next);
            }
        }
        return list.toString().replace("[", "<").replace("]", ">");
    }
}
