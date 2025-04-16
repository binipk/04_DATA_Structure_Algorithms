package com.ohgiraffers.section07.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/* 절댓값 힙 - 백준(11286) */
class Practice1Tests {
    Practice1 practice1;

    @BeforeEach
    void setUp() {
        practice1 = new Practice1();
    }

    @Test
    void solution() {
    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(new Integer[]{
                        1, -1, 0, 0, 0, 1, 1, -1, -1, 2, -2, 0, 0, 0, 0, 0, 0, 0},
                        "-1 1 0 -1 -1 1 1 -2 2 0")
        );
    }

    @DisplayName("절댓값 힙 테스트")
    @ParameterizedTest
    @MethodSource("provideSource")
    void solution(Integer[] arr, String output) {
        String result = practice1.solution(arr);
        System.out.println(output);
        System.out.println(result);
        assertEquals(output, result);
    }
}