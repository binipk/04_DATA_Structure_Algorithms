package com.ohgiraffers.section04.dp;

public class C_Tiling {

    public static int solution(int n) {
        // 예외 처리: 음수인 경우 0가지 방법밖에 없음
        if (n < 0) return 0;

        // 배열 선언: dp[i]는 2×i 크기의 직사각형을 채우는 방법 수
        int[] dp = new int[n + 2]; // 인덱스 범위 방지용 +2
        dp[0] = 1;  // 아무 것도 없는 경우도 1가지로 셈
        dp[1] = 1;  // 2×1은 1가지 방법만 존재 (세로 타일 한 개)

        // 점화식 적용: dp[i] = dp[i-1] + dp[i-2]
        // i-1까지 채우고 세로 타일 붙이기 + i-2까지 채우고 가로 타일 2개 붙이기
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
