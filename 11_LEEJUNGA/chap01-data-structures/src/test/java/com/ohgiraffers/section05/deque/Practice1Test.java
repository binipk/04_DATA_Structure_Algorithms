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

/* 풍선 터트리기 - 백준(2346) */
class Practice1Test {
    Practice1 practice1;

    @BeforeEach
    void setUp() {
        practice1 = new Practice1();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(5, "3 2 1 -3 -1", "1 4 5 3 2")
        );
    }

    @Timeout(value=1000, unit= TimeUnit.MILLISECONDS)
    @DisplayName("풍선 터뜨리기")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testParenthesisString(int input1, String input2, String expected) {
        String[] input2List = input2.split(" ");
        Integer[] notes = new Integer[input1];
        for (int i = 0; i < input1; i++) {
            notes[i] = Integer.parseInt(input2List[i]);
        }
        String result = practice1.solution(notes);
        Assertions.assertEquals(expected, result);
    }
}