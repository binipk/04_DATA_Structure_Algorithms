package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Practice1 {
    static class Balloon {
        int order;
        int noteValue;

        public Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }

    public static void main(String[] args) {
        Practice1 p1 = new Practice1();
        p1.solution(new Integer[]{3, 2, 1, -3, -1});
    }

    public String solution(Integer[] notes) {
        // 5
        // 3 2 1 -3 -1
        // 출력 : 1 4 5 3 2
        Deque<Balloon> deque = new ArrayDeque<>();
        for (int i = 1; i <= notes.length; i++) {
            deque.addLast(new Balloon(i, notes[i - 1]));
        }

        List<Integer> list = new ArrayList<>();

        // 첫번째 풍선
        Balloon balloon = deque.pollFirst();
        int note = balloon.noteValue;
        list.add(balloon.order);

        int cnt = 0;
        while (!deque.isEmpty()) {
            if (note > 0) {
                // 터진 풍선 값이 양수인 경우 -> deque 앞쪽부터 뒤로 옮기기
                cnt++;
                balloon = deque.pollFirst();
                if (cnt == note) {
                    cnt = 0;
                    note = balloon.noteValue;
                    list.add(balloon.order);
                    continue;
                }
                deque.addLast(balloon);
            } else {
                // 터진 풍선 값이 음수인 경유 -> deque 뒤쪽부터 앞으로 옮기기
                cnt++;
                balloon = deque.removeLast();
                if (cnt == Math.abs(note)) {
                    cnt = 0;
                    note = balloon.noteValue;
                    list.add(balloon.order);
                    continue;
                }
                deque.addFirst(balloon);
            }
        }

        String result = list.toString().replace("[", "").replace("]", "").replace(",", "");
        return result;
    }
}
