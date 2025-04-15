package com.ohgiraffers.section05.deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

        Deque<Balloon> deque = new LinkedList<>();

        for (int i = 0; i < notes.length; i++) {
            deque.add(new Balloon(i + 1, notes[i]));
        }

        List<Integer> result = new ArrayList<>();  // 터뜨린 순서를 저장할 리스트

        // 모든 풍선을 터트릴때까지 반복
        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();  // 맨 앞 풍선 터뜨리기
            result.add(current.order);            // 터뜨린 순서 기록
            int move = current.noteValue;         // 이동할 칸 수

            if (deque.isEmpty()) break;           // 풍선 다 터트렸으면 종료

            // deque.pollFirst()는 맨 앞의 값을 꺼내고, deque.addLast()는 맨 뒤에 값을 추가하는 메서드
            // deque.pollLast()는 맨 뒤의 값을 꺼내고, deque.addFirst()는 맨 앞에 값을 추가하는 메서드

            // 양수면 오른쪽 이동 (맨 앞의 값을 꺼내, 맨 뒤로 추가)
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }

            // 음수면 왼쪽 이동 (맨 뒤 값을 꺼내, 맨 앞으로 추가)
            if (move < 0) {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }

        }

        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

}
