package com.ohgiraffers.section03.stack;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Practice1Test1 {

    public static void main(String[] args) {
        // 테스트 입력 세트
        String input = "6\n" +
                "(())())\n" +
                "(((()())()\n" +
                "(()())((()))\n" +
                "((()()(()))(((())))()\n" +
                "()()()()(()()())()\n" +
                "(()((())()(()\n";

        // 기대 출력
        String[] expectedOutput = {
                "NO",
                "NO",
                "YES",
                "NO",
                "YES",
                "NO"
        };

        // System.in을 가짜 입력으로 바꿔서 테스트
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 테스트 실행
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        boolean allPassed = true;

        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            String result = Practice1.isVPS(line) ? "YES" : "NO";  // Practice1 클래스의 isVPS 호출

            if (!result.equals(expectedOutput[i])) {
                System.out.println("❌ 테스트 실패: 입력 \"" + line + "\" → 예상: " + expectedOutput[i] + ", 결과: " + result);
                allPassed = false;
            } else {
                System.out.println("✅ 테스트 통과: " + result);
            }
        }

        // 최종 결과
        if (allPassed) {
            System.out.println("\n🎉 모든 테스트 통과!");
        } else {
            System.out.println("\n🚨 일부 테스트 실패");
        }

        // 입력 원복
        System.setIn(originalIn);
    }
}
