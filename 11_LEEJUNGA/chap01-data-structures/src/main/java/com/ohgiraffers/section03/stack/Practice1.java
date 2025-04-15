package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice1 {
    /* 괄호 - 백준(9012) */
    public String solution(String input) {
        Stack<Character> stack = new Stack<>();
        try {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "NO";
        }

        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }
}
