package com.ohgiraffers.section04.dp;

// 파도반 수열을 구하는 프로그램
// 점화식: f(n) = f(n-2) + f(n-3) (n >= 4)
public class D_Padovan {

    // dp 배열을 사용하여 값을 저장 (최대 100까지 저장)
    static Integer[] dp = new Integer[101];

    // 주어진 n에 대해 파도반 수열의 값을 구하는 메서드
    public static int solution(int n) {
        // 초기값 설정 (P(1), P(2), P(3) = 1)
        dp[1] = dp[2] = dp[3] = 1;

        // 1. 탑다운 방식 (재귀 호출을 사용하여 계산)
        return padovan(n);
    }

    // 재귀적으로 파도반 수열 값을 구하는 메서드
    private static int padovan(int n) {
        // 만약 dp[n]이 아직 계산되지 않았다면
        if (dp[n] == null) {
            // 점화식에 따라 값을 계산하고 저장
            dp[n] = padovan(n - 2) + padovan(n - 3);
        }
        // 계산된 값을 리턴
        return dp[n];
    }
}
