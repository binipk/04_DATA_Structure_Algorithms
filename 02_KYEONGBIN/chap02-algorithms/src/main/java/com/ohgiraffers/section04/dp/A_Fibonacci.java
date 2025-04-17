package com.ohgiraffers.section04.dp;

public class A_Fibonacci {

    // 📌 1. 기본 재귀 방식으로 피보나치 수 구하기
    public static int getFibonacciNumber(int n) {

        // 기저 조건 1: n이 0이면 0을 반환
        if (n == 0) return 0;

            // 기저 조건 2: n이 1이면 1을 반환
        else if (n == 1) return 1;

        // 재귀 호출: 이전 두 항의 합을 재귀적으로 계산
        return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }

    // ✅ 2. 동적 계획법 - Top Down 방식 (메모이제이션 사용)
    // 이미 계산한 값을 배열에 저장하고, 필요 시 재사용하여 중복 계산을 줄임
    static int[] dp = new int[50];  // 계산 결과를 저장할 배열 (최대 n = 49까지 가능)

    public static int getFibonacciNumberDP(int n) {

        // 기저 조건 처리
        if (n == 0) return 0;
        else if (n == 1) return 1;

        // 👉 dp[n]이 0이면 아직 계산하지 않은 상태
        if (dp[n] == 0) {
            // 계산 후 결과 저장
            dp[n] = getFibonacciNumberDP(n - 1) + getFibonacciNumberDP(n - 2);
        }

        // 👉 이미 계산된 값이면, 저장된 값 사용
        return dp[n];
    }

    // ✅ 3. 동적 계획법 - Bottom Up 방식 (타뷸레이션)
    // 반복문을 이용하여 작은 문제부터 차례로 해결

    static int getFibonacciNumberIter(int n) {

        // 계산 결과 저장용 배열: n번째 수까지 저장 가능
        int[] arr = new int[n + 1];

        // 기본 초기값 설정
        arr[0] = 0;
        arr[1] = 1;

        // 예외 처리: n이 0 또는 1인 경우 미리 리턴
        if (n == 0) return arr[0];
        else if (n == 1) return arr[1];
        else {
            // 👉 반복문으로 2부터 n까지 차례로 계산
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];  // 이전 두 항의 합 저장
            }

            // 최종 결과 리턴
            return arr[n];
        }
    }
}
