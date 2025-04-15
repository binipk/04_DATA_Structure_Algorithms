package com.ohgiraffers.section05.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* 풍선 터트리기 - 백준(2346) */
class Practice1Tests {
    @Test
    void testBalloonPopping() {
        // 테스트 케이스 설정
        Integer[] notes = {3,2,1,-3,-1};
        String expected = "1 4 5 3 2";

        // Practice1.Balloon 클래스의 인스턴스 생성
        Practice1.Balloon solver = new Practice1.Balloon(0,0);

        // solution 메소드 호출 및 결과 검증
        String actual = solver.solution(notes);

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, actual);
    }

    @Test
    void testBalloonPoppingWithAnotherEx() {
        // 다른 테스트 케이스 설정
        Integer[] notes = {5,3,2,1,-3,-1};
        String expected = "1 6 5 2 3 4"; // 예상 결과 (문제 설명에 따라 다를 수 있음)

        Practice1.Balloon solver = new Practice1.Balloon(0,0);
        String actual = solver.solution(notes);

        assertEquals(expected, actual);
    }
}