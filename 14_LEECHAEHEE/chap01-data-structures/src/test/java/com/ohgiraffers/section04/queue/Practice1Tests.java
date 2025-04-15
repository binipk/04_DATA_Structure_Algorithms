package com.ohgiraffers.section04.queue;

import com.ohgiraffers.section03.stack.Practice1;
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

/* 요세푸스 문제 - 백준(1158) */
class Practice1Tests {
Practice1 prac;

    @BeforeEach
    void setUp() {
        prac = new Practice1();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(7, 3)
        );
    }

    @DisplayName("요세푸스 순열 테스트")
    @Timeout(value=2000, unit= TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testParentthesisString(String input, String expected) {
        String result = prac.solution(input);
        Assertions.assertEquals(expected, result);
    }
}