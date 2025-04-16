package com.ohgiraffers.section03.stack;

import com.sun.jdi.connect.Connector;

import java.util.Stack;

public class Practice1 {
    // 실제로 코드를 구현
    public String solution(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
