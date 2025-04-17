package com.ohgiraffers.section04.dp;

import java.util.Arrays;

public class B_SugarDelivery {

    // 아주 큰 숫자로 초기화하기 위한 상수 (불가능한 경우 표시용)
    static final int INF = 9999;

    public static int solution(int n) {

        // dp[i]는 ikg을 만들기 위한 최소 봉지 수
        int[] dp = new int[n + 1];

        // 모든 값 초기화 (처음엔 다 불가능한 값으로)
        Arrays.fill(dp, INF);

        // 초기 조건 설정
        if (n > 3) dp[3] = 1;   // 3kg 1개
        if (n >= 5) dp[5] = 1;  // 5kg 1개

        // 점화식 적용: dp[i] = min(dp[i-3], dp[i-5]) + 1
        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        // 만약 만들 수 없는 경우(INF 그대로면) -1 반환
        return dp[n] >= INF ? -1 : dp[n];
    }
}
