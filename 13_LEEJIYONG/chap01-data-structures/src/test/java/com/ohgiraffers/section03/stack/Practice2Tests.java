package com.ohgiraffers.section03.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/* 쇠막대기 백준(10799)
* https://www.acmicpc.net/problem/10799
* */
class Practice2Tests {

    Practice2 practice2;

    @BeforeEach
    public void setUp(){
        practice2 = new Practice2();
    }

    static Stream<Arguments> provideTestCase(){
        return Stream.of(Arguments.arguments("()(((()())(())()))(())", 17),
            Arguments.arguments("(((()(()()))(())()))(()())", 24)
        );
    }

    @DisplayName("쇠막대기 백준")
    @Timeout(value= 1000, unit = TimeUnit.MICROSECONDS)
    @ParameterizedTest
    @MethodSource("provideTestCase")
    void test(String input, int expected){
        int result = practice2.solution(input);
        Assertions.assertEquals(expected, result);
    }

}