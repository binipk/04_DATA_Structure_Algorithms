package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice2 {
    public String solution(String input) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop(); // 일단 pop

                // 레이저인지 확인
                if (input.charAt(i - 1) == '(') {
                    count += stack.size(); // 레이저: 스택에 있는 만큼 잘림
                } else {
                    count++; // 막대 끝: 잘린 조각 하나 추가
                }
            }
        }

        return String.valueOf(count);
    }
}
