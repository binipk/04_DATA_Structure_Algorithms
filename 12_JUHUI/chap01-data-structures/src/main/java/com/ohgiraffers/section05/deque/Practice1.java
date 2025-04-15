package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Practice1 {

    static class Balloon {
        int order;
        int noteValue;

        Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }

        public String solution(Integer[] notes) {
            // 풍선 객체들을 덱에 넣기
            Deque<Balloon> balloons = new ArrayDeque<>();
            StringBuilder result = new StringBuilder();

            // 풍선 초기화
            for (int i = 0; i < notes.length; i++) {
                balloons.add(new Balloon(i+1, notes[i]));
            }

            // 첫 번째 풍선 처리
            Balloon current = balloons.pollFirst();
            result.append(current.order).append(" "); // // noteValue는 출력하지 않음
            // pollFirst(): 덱의 앞쪽에서 데이터를 제거하고 반환 (비어있으면 null 반환)

            // 나머지 풍선 처리
            while (!balloons.isEmpty()) {
                int move = current.noteValue;

                if (move > 0) {
                   // 양수 : 오른쪽으로 이동(이미 하나 제거했으므로 move-1만큼 이동)
                   for (int i = 0; i < move - 1; i++) {
                       balloons.addLast(balloons.pollFirst());
                       // offerLast(x): 데이터 x를 덱의 뒤쪽에 추가 (실패 시 false 반환)
                   }
                   current = balloons.pollFirst();
                } else {
                    // 음수 : 왼쪽으로 이동. abs는 절대값
                    for (int i = 0; i < Math.abs(move); i++) {
                        balloons.addFirst(balloons.pollLast()); //addFirst(x): 데이터 x를 덱의 앞쪽에 추가
                    }
                    current = balloons.pollFirst();
                }
                result.append(current.order).append(" ");
            }
            return result.toString().trim();
        }
    }

    // 테스트 코드 실행을 위한 메인 메소드
    public static void main(String[] args) {
        Practice1.Balloon solver = new Practice1.Balloon(0,0); // 임시 객체 생성

        // 예제 입력
        Integer[] notes = new Integer[]{3,2,1,-3,-1};
        System.out.println(solver.solution(notes));
    }
}
