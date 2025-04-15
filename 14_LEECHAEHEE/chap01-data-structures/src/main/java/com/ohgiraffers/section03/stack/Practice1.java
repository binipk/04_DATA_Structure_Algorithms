package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice1 {
    // 실제로 코드를 구현
    public String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                //스택이 비어서 괄호를 꺼낼 수 없다면 여는 괄호 부족, 짝이 안맞음
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        // 스택이 안 비어있으면 여는 괄호가 남아있는 상황. 짝이 안맞음
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
