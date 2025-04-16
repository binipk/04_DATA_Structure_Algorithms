package com.ohgiraffers.section07.heap;

import java.util.PriorityQueue;

public class Practice1 {
    public String solution(Integer[] array) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int absCompare = Integer.compare(Math.abs(o1), Math.abs(o2));
            if (absCompare == 0) {
                return Integer.compare(o1, o2);
            } else {
                return absCompare;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int x : array) {
            if (x == 0) {
                if(pq.isEmpty()) {
                    sb.append("0 ");
                } else {
                    sb.append(pq.poll()).append(" ");
                }
            } else {
                pq.offer(x);
            }

        }
        return sb.toString().trim();
    }
}
