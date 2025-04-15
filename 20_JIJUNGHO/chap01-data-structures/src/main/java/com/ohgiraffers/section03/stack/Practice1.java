package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice1 {

    // 실제로 코드를 구현
    public String solution(String input) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0;  i < input.length(); i++) {

            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
