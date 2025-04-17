package com.ohgiraffers.section04.dp;

import java.util.Arrays;

public class B_SugarDelivery {

    // 최대값 상수를 지정
    static final int INF = 9999;

    public static int solution(int n) {
        /* dp 배열의 인덱스 값이 곧 해당 키로수의 봉지 개수가 될 수 있도록 저장한다. */
        int[] dp = new int[n + 1];

        /* 배열의 모든 값 초기화 */
        /* 모든 값을 INF값으로 초기화 */
        Arrays.fill(dp, INF);

        /*
        * n으로 전달되는 숫자가 작으면 인덱스 범위를 벗어날 수 있기 때문에
        * 초기값 설정 시 확인하고 반복문은 그 뒤부터 전개한다.
        * */
        if(n >= 3) dp[3] = 1;
        if(n >= 5) dp[5] = 1;

        for(int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        return dp[n] >= INF? -1 : dp[n];
    }
}
