package com.ohgiraffers.section04.queue;

import com.ohgiraffers.section04.queue.Practice1;
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

/* 백준 1158 - 요세푸스 문제 */
class Practice1Test {
    Practice1 practice1;

    @BeforeEach
    void setUp() {
        practice1 = new Practice1();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments("7 3", "<3, 6, 2, 7, 5, 1, 4>")
        );
    }

    @Timeout(value=1000, unit= TimeUnit.MILLISECONDS)
    @DisplayName("요세푸스 문제")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testParenthesisString(String input, String expected) {
        String[] inputs = input.split(" ");
        String result = practice1.solution(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        Assertions.assertEquals(expected, result);
    }
}