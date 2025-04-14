package com.ohgiraffers.section03.stack;

import java.util.Scanner;
import java.util.Stack;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();  // 개행 처리

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            System.out.println(isVPS(str) ? "YES" : "NO");
        }
    }

    public static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
