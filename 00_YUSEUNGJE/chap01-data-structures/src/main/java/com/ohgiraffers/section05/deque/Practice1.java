package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice1 {

    static class Balloon {
        int order;
        int noteValue;

        Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }

    public String solution(Integer[] notes) {
        StringBuilder sb = new StringBuilder();

        // 풍선을 Deque에 삽입
        Deque<Balloon> balloons = new ArrayDeque<>();
        for (int i = 0; i < notes.length; i++) {
            balloons.add(new Balloon(i + 1, notes[i]));
        }

        // 무조건 첫 번째 풍선이 먼저 제거
        Balloon current = balloons.removeFirst();
        sb.append(current.order);

        // 모든 풍선이 터질 때까지 반복
        while(!balloons.isEmpty()) {

            // 터진 풍선에 기록 된 이동 값
            int moveValue = current.noteValue;

            if(moveValue > 0) {
                // 양수는 오른쪽 이동이므로 이동 값 만큼 앞 요소를 빼서 뒤로 삽입
                for(int i = 1; i < moveValue; i++) {
                    balloons.addLast(balloons.removeFirst());
                }
                current = balloons.removeFirst();
            } else {
                // 음수는 왼쪽 이동이므로 이동 값 만큼 뒷 요소를 빼서 앞으로 삽입
                for(int i = 1; i < -moveValue; i++) {
                    balloons.addFirst(balloons.removeLast());
                }
                current = balloons.removeLast();
            }

            sb.append(" ").append(current.order);
        }

        return sb.toString();
    }
}
