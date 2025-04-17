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

class B_SugarDeliveryTest {

    // 테스트에 사용할 입력값과 기대 결과값을 미리 변수로 선언
    private static Integer input1, input2, input3;
    private static Integer output1, output2, output3;

    // 테스트 시작 전에 한 번만 실행되는 초기화 메서드
    @BeforeAll
    public static void setUp() {
        input1 = 18; output1 = 4;   // 18kg → 4봉지 (5kg x 3 + 3kg x 1)
        input2 = 4;  output2 = -1;  // 4kg → 불가능
        input3 = 6;  output3 = 2;   // 6kg → 3kg x 2
    }

    // 테스트에 사용할 파라미터들을 묶어서 제공하는 메서드
    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2),
                arguments(input3, output3)
        );
    }

    // 각 입력값에 대해 B_SugarDelivery.solution() 메서드를 실행하고
    // 결과가 예상값과 같은지 확인
    @DisplayName("SugarDelivery")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)  // 1초 안에 실행되도록 제한
    @ParameterizedTest
    @MethodSource("provideSource")
    public void sugarDeliveryTest(Integer input, Integer output) throws Exception {
        Integer result = B_SugarDelivery.solution(input);
        Assertions.assertEquals(output, result);  // 결과 비교
    }
}
