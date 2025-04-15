package com.ohgiraffers.section03.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Practice2Tests {
/* 쇠막대기 백준(10799) */
/* https://www.acmicpc.net/problem/10799 */
    @Test
    void testLaserCuttingIronStick() {
        // given
        Practice2 practice = new Practice2();
        String arrangement = "()(((()())(())()))(())";
        int expected = 17;

        // when
        int result = practice.solution(arrangement);

        // then
        assertEquals(expected, result);
    }

    @Test
    void tessAdditionalCase() {
        // given
        Practice2 practice = new Practice2();
        String arrangement = "(((()(()()))(())()))(()())";
        int expected = 24;

        // when
        int result = practice.solution(arrangement);

        // then
        assertEquals(expected, result);
        //assertEquals(expected, actual): 두 값이 같은지 확인한다.

    }
}