package com.ohgiraffers.section03.stack;

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

/* 괄호 - 백준(9012) */
class Practice1Tests {

    Practice1 practice1;

    @BeforeEach
    void setUp() {
        practice1 = new Practice1(); // practice1이라는 객체를 메소드를 실행할때마다 호출
    }

    static Stream<Arguments> provideTestCase() {
        return Stream.of(
                Arguments.arguments("(())())", "NO"),
                Arguments.arguments("(((()())()", "NO"),
                Arguments.arguments("(()())((()))", "YES"),
                Arguments.arguments("((()()(()))(((())))()", "NO"),
                Arguments.arguments("()()()()(()()())()", "YES"),
                Arguments.arguments("(()((())()(", "NO")
        );
    }

    @DisplayName("올바른 괄호 문자열 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideTestCase")
    void testParenthesisString(String input, String expected) {
        String result = practice1.solution(input);
        Assertions.assertEquals(expected, result);
    }

}