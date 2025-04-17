package com.ohgiraffers.section02.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class A_DFSTest {

    // 테스트용 입력(input)과 예상 출력(output)을 저장할 변수
    static String input;
    static Integer output;

    // 테스트 실행 전에 딱 한 번만 실행되는 메서드 (입력/출력 값 세팅)
    @BeforeAll
    static void setUp() {
        input = "7\n" + // 총 7개의 노드가 있음
                "6\n" + // 간선(edge)은 6개
                "1 2\n" + // 1번과 2번 노드 연결
                "2 3\n" + // 2번과 3번 연결
                "1 5\n" + // 1번과 5번 연결
                "5 2\n" + // 5번과 2번 연결
                "5 6\n" + // 5번과 6번 연결
                "4 7";    // 4번과 7번 연결 (1번과는 연결되지 않음)
        output = 4;       // 1번을 통해 바이러스 감염되는 컴퓨터 수는 총 4개 (2, 3, 5, 6)
    }

    // 여러 개의 테스트 케이스를 제공하는 메서드 (여기선 하나만 있음)
    static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.arguments(input, output) // (입력, 기대 출력)
        );
    }

    @DisplayName("dfs") // 테스트 이름
    @ParameterizedTest // 파라미터 여러 개 넣을 수 있는 테스트임
    @MethodSource("provideSource") // 위에서 만든 provideSource()를 이용함
    void dfsTest(String input, Integer output) throws IOException {
        // A_DFS 클래스의 solution() 메서드 실행 결과
        Integer result = A_DFS.solution(input);

        // 기대 결과(output)와 실제 결과(result)가 같은지 비교
        Assertions.assertEquals(output, result);
    }
}
