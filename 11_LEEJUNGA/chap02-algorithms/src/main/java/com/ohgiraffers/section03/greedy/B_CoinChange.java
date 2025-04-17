package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class B_CoinChange {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전개수
        int price =  Integer.parseInt(st.nextToken()); // 계산금액

        int[] coinArr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine(), "\n");
            coinArr[i] = Integer.parseInt(st.nextToken());
        }

        int totalCnt = 0;
        for (int i = 0; i < coinArr.length; i++) {
            int cnt = price / coinArr[i];
            totalCnt += cnt;
            price -= (cnt * coinArr[i]);
        }

        return totalCnt;
    }
}
