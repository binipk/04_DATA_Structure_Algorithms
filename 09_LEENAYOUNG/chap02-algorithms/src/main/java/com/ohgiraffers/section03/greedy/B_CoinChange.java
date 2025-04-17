package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class B_CoinChange {

    public static int solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 동전의 종류 개수
        int K = Integer.parseInt(st.nextToken());  // 계산할 금액

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;  // 필요한 동전의 개수

        for (int i = N - 1; i >= 0; i--){
            if (coins[i] <= K) {
                // 현재의 동전으로 최대 지불할 수 있는 금액(동전의 수)
                count += K / coins[i];
                // 방금 지불하고 남은 금액을 다시 동전 확인을 위해 K에 대입
                K %= coins[i];
            }
        }

        return count;
    }
}
