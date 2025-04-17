package com.ohgiraffers.section02.searching;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException; // ✅ IOException import 추가
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class B_BFSTest {

    // 테스트용 입력 데이터와 기대 출력값을 저장하는 변수들
    static String input1, input2, input3;
    static Integer output1, output2, output3;

    // 테스트 시작 전에 딱 한 번 실행되는 초기화 메서드
    @BeforeAll
    public static void set() {

        // 🎯 테스트 케이스 1: 배추 덩어리가 5개
        input1 = "10 8 17\n" +
                "0 0\n" +
                "1 0\n" +
                "1 1\n" +
                "4 2\n" +
                "4 3\n" +
                "4 5\n" +
                "2 4\n" +
                "3 4\n" +
                "7 4\n" +
                "8 4\n" +
                "9 4\n" +
                "7 5\n" +
                "8 5\n" +
                "9 5\n" +
                "7 6\n" +
                "8 6\n" +
                "9 6";
        output1 = 5;

        // 🎯 테스트 케이스 2: 배추가 한 포기 (지렁이 1마리)
        input2 = "10 10 1\n" +
                "5 5\n";
        output2 = 1;

        // 🎯 테스트 케이스 3: 세로로 붙은 배추들 + 떨어진 배추
        input3 = "5 3 6\n" +
                "0 2\n" +
                "1 2\n" +
                "2 2\n" +
                "3 2\n" +
                "4 2\n" +
                "4 0";
        output3 = 2;
    }

    // 테스트 케이스들을 Stream 형태로 제공
    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2),
                arguments(input3, output3)
        );
    }

    @DisplayName("BFS 배추 문제 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void bfsTest(String input, Integer output) throws IOException { // ✅ throws 추가됨
        Integer result = B_BFS.solution(input);
        assertEquals(output, result);
    }
}
