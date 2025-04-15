package com.ohgiraffers.section04.queue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/* 요세푸스 문제 - 백준(1158)*/
class Practice1Tests {

    Practice1 practice1;

    @BeforeEach
    void setUp(){
        practice1 = new Practice1();
    }

    static Stream<Arguments> provideTestCase(){
        return Stream.of(Arguments.of(7, 3, "<3, 6, 2, 7, 5, 1, 4>"));
    }

    @DisplayName("요세푸스")
    @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideTestCase")
    void test(int n, int k, String expected){
        String result = practice1.solution(n, k);

        Assertions.assertEquals(expected, result);
    }
}