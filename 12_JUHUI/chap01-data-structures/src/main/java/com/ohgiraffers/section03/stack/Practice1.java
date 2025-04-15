package com.ohgiraffers.section03.stack;

import java.util.Scanner;
import java.util.Stack;

public class Practice1 {
    // 실제로 코드를 구현할 부분
    public String solution(String input) {
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()) {
            if(c == '(') {
                // 여는 괄호인 경우 stack에 push
                stack.push(c);
            } else {
                // 스택이 비어서 괄호를 꺼낼 수 없다면 여는 괄호가 부족해서 짝이 안 맞는 상황
                if(stack.isEmpty()) return "NO";
                // 닫는 괄호인 경우 stack에서 pop
                stack.pop();
            }
        }

        // 모든 문자에 대해서 처리 했는데 스택에 여는 괄호가 남아있다는 것은 닫는 괄호가 부족해서 짝이 안 맞는 상황
        if(!stack.isEmpty()) return "NO";

        return "YES";
    }
}
