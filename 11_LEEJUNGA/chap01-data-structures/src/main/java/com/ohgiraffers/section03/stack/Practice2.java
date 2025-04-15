package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice2 {
    /* 쇠막대기 - 백준(10799) */
    public int solution(String input) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        // () ((( () () )( () ) () ))( () )
        // () 일때 cnt += 스택길이
        // ( 일때 스택쌓기
        // ) 일때 스택 pop 후 cnt++

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (input.charAt(i - 1) == '(') {
                    stack.pop();
                    cnt += stack.size();
                } else {
                    stack.pop();
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
