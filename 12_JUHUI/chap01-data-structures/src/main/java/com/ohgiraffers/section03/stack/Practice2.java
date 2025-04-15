package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice2 {
    public int solution(String arrangment) {
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < arrangment.length(); i++) {
            char current = arrangment.charAt(i);

            if(current == '(') {
                stack.push(current);
            } else { // current == ')'
                stack.pop(); // 여는 괄호 제거

                // 바로 이전 문자가 '('인 경우는 레이저
                if(arrangment.charAt(i - 1) == '(') {
                    result += stack.size(); // 현재 스택에 있는 괄호 수만큼 조각이 생김
                } else {
                    result += 1; // 쇠막대기의 끝부분, 조각 1개 추가
                }
            }
        }
        return result;
    }
}
