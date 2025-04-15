package com.ohgiraffers.section05.deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/* 풍선 터트리기 - 백준(2346)
* https://www.acmicpc.net/problem/2346
* */
class Practice1Tests {
    Practice1 practice1;

    @BeforeEach
    void setUp() {
        practice1 = new Practice1();
    }

    static Stream<Arguments> provideNotes() {
        return Stream.of(
                Arguments.of()
        );
    }

    @DisplayName("풍선 터뜨리기 테스트")
    @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideNotes")
    void testParentthesisString(Integer[] notes, String expected) {
        String result = practice1.solution(notes);
        Assertions.assertEquals(expected, result);
    }



}