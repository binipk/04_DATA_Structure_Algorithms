package com.ohgiraffers.section03.stack;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/* 괄호 - 백준(9012) */
class Practice1Tests {
    Practice1 practice1;

    @BeforeEach
    void setUp() {
        practice1 = new Practice1();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments("(())())", "NO"),
                Arguments.arguments("(((()())()", "NO"),
                Arguments.arguments("(()())((()))", "YES"),
                Arguments.arguments("((()()(()))(((())))()", "NO"),
                Arguments.arguments("()()()()(()()())()", "YES"),
                Arguments.arguments("(()((())()(", "NO"),
                Arguments.arguments("((", "NO"),
                Arguments.arguments("))", "NO"),
                Arguments.arguments("())(()", "NO")
        );
    }

    @DisplayName("올바른 괄호 문자열 테스트")
    @Timeout(value=1000, unit= TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testParentthesisString(String input, String expected) {
        String result = practice1.solution(input);
        Assertions.assertEquals(expected, result);
    }
}