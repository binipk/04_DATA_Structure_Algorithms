package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice2 {

    public int solution(String input) {
        int cnt = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            /* 여는 괄호는 stack에 push, 닫는 괄호는 stack에서 pop 해서 짝을 맞춘다. */
            if(input.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                /* 닫는 괄호 앞에 여는 괄호가 있었다면 레이저이므로 막대기가 잘린다.
                현재 stack에 쌓인 개수가 쌓인 막대기의 개수이므로 사이즈만큼을 더한다.
                닫는 괄호 앞에 닫는 괄호가 있었다면 막대기의 끝을 의미하므로 1을 더한다. */
                if(input.charAt(i - 1) == '(') {
                    cnt += stack.size();
                } else {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
