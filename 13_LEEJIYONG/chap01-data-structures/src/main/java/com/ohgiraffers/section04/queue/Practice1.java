package com.ohgiraffers.section04.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice1 {
    public String solution(int n, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            q.addLast(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int cnt = 0;

            for (int i = 1; i < k; i++) {
                int tmp = q.removeFirst();
                q.addLast(tmp);
            }

            result.add(q.removeFirst());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                sb.append(result.get(i)).append(">");
                break;
            }
            sb.append(result.get(i)).append(", ");
        }

        return sb.toString();
    }
}