package com.ohgiraffers.section04.dp; // 패키지 선언

import java.io.BufferedReader;   // 문자열 입력을 효율적으로 읽기 위한 클래스
import java.io.IOException;      // 입출력 예외 처리를 위한 클래스
import java.io.StringReader;     // 문자열을 입력 스트림처럼 사용할 수 있게 해주는 클래스

public class F_StairClimbing {

    public static int solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input)); // 문자열 입력을 BufferedReader로 처리
        int n = Integer.parseInt(br.readLine());                         // 첫 줄: 계단 개수

        int[] arr = new int[n + 1]; // 계단 점수를 저장하는 배열 (1-based index)
        int[] dp  = new int[n + 1]; // dp[i]: i번째 계단까지의 최대 점수

        // 계단 점수 입력
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.read
                    Line());
        }

        // 초기값 설정
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = dp[1] + arr[2];
        }

        // 점화식 적용 (3번째 계단부터)
        for (int i = 3; i <= n; i++) {
            // 1. i-3 → i-1 → i (연속 3칸 방지)
            // 2. i-2 → i
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }

        return dp[n]; // 마지막 계단에서의 최대 점수 반환
    }
}
