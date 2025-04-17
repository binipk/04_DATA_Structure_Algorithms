package com.ohgiraffers.section04.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class C_TilingTest {

    // 테스트 입력값과 기대 출력값을 저장할 변수 선언
    private static Integer input1, input2;
    private static Integer output1, output2;

    // ✅ 테스트 실행 전에 한 번만 실행되는 초기 설정 메서드
    @BeforeAll
    static void setUp() {

        input1 = 2;    // 2×2 타일링의 경우의 수: 2가지 (세로2 or 가로2)
        output1 = 2;

        input2 = 9;    // 2×9 타일링의 경우의 수: 55가지 (피보나치와 동일)
        output2 = 55;
    }

    // ✅ 테스트용 데이터 스트림을 생성하는 메서드
    static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }

    // ✅ 타일링 문제 테스트
    @DisplayName("Tiling")  // 테스트 이름 출력용
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)  // 1초 이내로 실행 제한
    @ParameterizedTest  // 파라미터 기반 테스트
    @MethodSource("provideSource")  // 위에서 만든 테스트 데이터를 사용
    void tilingTest(Integer input, Integer output) throws Exception {
        // 타일링 알고리즘 실행
        Integer result = C_Tiling.solution(input);

        // 결과가 기대값과 일치하는지 확인
        Assertions.assertEquals(output, result);
    }
}
