package com.ohgiraffers.section04.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class A_FibonacciTest {

    // ✅ 테스트 입력값과 예상 출력값을 제공하는 메서드
    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(10, 55),         // 피보나치 수열의 10번째 항은 55
                arguments(40, 102334155)   // 피보나치 수열의 40번째 항은 102334155
        );
    }

    // ✅ 테스트 1: 기본 재귀 방식으로 피보나치 수를 계산하는 메서드 테스트
    @DisplayName("기본 재귀 피보나치")
    @ParameterizedTest                           // 여러 입력값으로 테스트할 수 있게 함
    @MethodSource("provideSource")               // 위의 provideSource() 메서드에서 데이터 가져옴
    public void fibonacciTest1(int input, int output) {
        // 📌 재귀 방식으로 피보나치 수 계산
        int result = A_Fibonacci.getFibonacciNumber(input);

        // 📌 예상 결과(output)와 실제 계산 결과(result)를 비교
        Assertions.assertEquals(output, result);
    }

    // ✅ 테스트 2: 동적 계획법 - Top Down 방식 테스트 (메모이제이션 사용)
    @DisplayName("DP-TOP Down 피보나치")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void fibonacciTest2(int input, int output) {
        // 📌 Top-Down 방식 피보나치 수 계산 (재귀 + 저장)
        int result = A_Fibonacci.getFibonacciNumberDP(input);

        // 📌 예상값과 비교
        Assertions.assertEquals(output, result);
    }

    // ✅ 테스트 3: 동적 계획법 - Bottom Up 방식 테스트 (반복문 사용)
    @DisplayName("DP-Bottom-Up 피보나치")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void fibonacciTest3(int input, int output) {
        // 📌 Bottom-Up 방식 피보나치 수 계산 (반복문으로 계산)
        int result = A_Fibonacci.getFibonacciNumberIter(input);

        // 📌 예상값과 비교
        Assertions.assertEquals(output, result);
    }
}
