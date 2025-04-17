package com.ohgiraffers.section03.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class E_UnionAndFindTests {
    static String input1, input2;
    static String output1, output2;

    @BeforeAll
    public static void set() {

        input1 = "9 7\n" +
                " 1 2\n" +
                " 2 3\n" +
                " 3 4\n" +
                " 1 5\n" +
                " 6 7\n" +
                " 7 8\n" +
                " 8 9\n" +
                " 3 8";
        output1 = "NO";

        input2 = "9 7\n" +
                " 1 2\n" +
                " 2 3\n" +
                " 3 4\n" +
                " 1 5\n" +
                " 6 7\n" +
                " 7 8\n" +
                " 8 9\n" +
                " 3 5";
        output2 = "YES";
    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }

    @DisplayName("Union & Find")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void unionAndFindTest(String input, String output) throws IOException {
        String result = E_UnionAndFind.solution(input);
        Assertions.assertEquals(output, result);
    }
}