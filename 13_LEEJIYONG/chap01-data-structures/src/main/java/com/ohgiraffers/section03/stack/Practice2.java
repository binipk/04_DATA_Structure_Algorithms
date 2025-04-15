package com.ohgiraffers.section03.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Practice2 {

    public int solution(String input) {
        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        boolean flag = false;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                flag = true;
            } else {
                stack.pop();
                if (flag) {
                    cnt += stack.size();
                } else {
                    cnt++;
                }

                flag = false;
            }
        }
        return cnt;
    }
}
