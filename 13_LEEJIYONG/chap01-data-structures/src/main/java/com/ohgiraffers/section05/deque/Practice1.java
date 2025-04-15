package com.ohgiraffers.section05.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Practice1 {

    static class Balloon {
        int order;
        int noteValue;

        Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }

    public String solution(int N, String input) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            int tmp = deque.removeFirst();
            sb.append(tmp).append(" ");

            int dir = arr[tmp];
            if (dir > 0) {
                dir--;
            }

            if (!deque.isEmpty()) {
                while (dir != 0) {
                    if (dir > 0) {
                        deque.addLast(deque.removeFirst());
                        dir--;
                    } else {
                        deque.addFirst(deque.removeLast());
                        dir++;
                    }
                }
            }

        }

        return sb.toString();
    }
}
