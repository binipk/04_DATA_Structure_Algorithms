package com.ohgiraffers.section05.deque;


import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/* 풍선 터트리기 - 백준(2346)
* https://www.acmicpc.net/problem/2346
* */
class Practice1Tests {

    Practice1 practice1;

    @BeforeEach
    void setUp(){
        practice1 = new Practice1();
    }


    static Stream<Arguments> provideTestCase(){
        return Stream.of(Arguments.arguments(5, "3 2 1 -3 -1", "1 4 5 3 2"));
    }


    @DisplayName("풍선터뜨리기")
    @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideTestCase")
    void test(int N, String input, String expected){
        String result = practice1.solution(N, input);

        Assertions.assertEquals(expected, result);
    }
}