package com.ohgiraffers.section04.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/* 요세푸스 문제 - 백준(1158) */
class Practice1Tests {
    @Test
    void testYosePhus() throws Exception {
        // given - 테스트를 위한 준비물
        Practice1 p = new Practice1(); // 테스트할 클래스 생성
        int n = 7; // 첫 번째 입력값
        int k = 3; // 두 번째 입력값
        String expected = "<3, 6, 2, 7, 5, 1, 4>"; //기대하는 결과

        // when - 실제로 테스트할 코드 실행
        String result = p.solution(n, k); // 코드의 결과

        // then - 결과 확인
        assertEquals(expected, result); // 기대한 결과와 실제 결과가 같은지 확인
    }

    @Test
    void testAdditionalCase() throws Exception {
        // given
        Practice1 p = new Practice1();
        int n = 5;
        int k = 2;
        String expected = "<2, 4, 1, 5, 3>";

        // when
        String result = p.solution(n, k);

        // then
        assertEquals(expected, result);
    }
}