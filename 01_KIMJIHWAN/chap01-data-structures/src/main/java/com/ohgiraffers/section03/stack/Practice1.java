package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice1 {

    // 실제로 코드를 구현
    public String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                // 여는 괄호인 경우 stack에 push
                stack.push(c);
            } else {
                // 스택이 비어서 괄호를 꺼낼 수 없다면 여는 괄호
                if(stack.isEmpty()) return "NO";
                    // 여는 괄호인 경우 stack에 push
                stack.push(c);
            }
        }

        return null;
    }
}
