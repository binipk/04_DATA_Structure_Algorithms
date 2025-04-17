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

class E_UnionAndFindTest {

    static String input1, input2;    // 테스트 입력을 담을 변수
    static String output1, output2;  // 기대되는 출력 결과를 담을 변수

    @BeforeAll
    public static void set() {
        // 테스트 입력 데이터와 기대 결과를 미리 설정함

        input1 = "9 7\n" +              // 학생 수 9명, 친구 관계 7쌍
                " 1 2\n" +
                " 2 3\n" +
                " 3 4\n" +
                " 1 5\n" +
                " 6 7\n" +
                " 7 8\n" +
                " 8 9\n" +
                " 3 8";               // 마지막 줄: 3과 8이 같은 집합인지 확인
        output1 = "NO";                // 3과 8은 서로 다른 집합 (연결 안됨)

        input2 = "9 7\n" +              // 위와 동일한 구조, 마지막 확인만 다름
                " 1 2\n" +
                " 2 3\n" +
                " 3 4\n" +
                " 1 5\n" +
                " 6 7\n" +
                " 7 8\n" +
                " 8 9\n" +
                " 3 5";               // 마지막 줄: 3과 5가 같은 집합인지 확인
        output2 = "YES";               // 3과 5는 1을 통해 같은 집합으로 연결됨
    }

    // 파라미터 테스트에 사용할 입력/출력 데이터를 스트림으로 제공
    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }

    @DisplayName("Union & Find") // 테스트 실행 시 출력될 이름
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS) // 테스트 시간 제한 설정
    @ParameterizedTest // 여러 개의 테스트 케이스를 자동으로 실행
    @MethodSource("provideSource") // 위에서 정의한 파라미터 공급자 메서드 사용
    public void unionAndFindTest(String input, String output) throws IOException {
        // 실제 유니온 파인드 알고리즘 메서드를 실행하고 결과를 검증
        String result = E_UnionAndFind.solution(input);
        Assertions.assertEquals(output, result); // 기대한 결과와 실제 결과가 같은지 확인
    }
}
