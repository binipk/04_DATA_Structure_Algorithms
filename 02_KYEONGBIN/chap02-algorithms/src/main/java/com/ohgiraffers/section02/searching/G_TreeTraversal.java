package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_TreeTraversal {

    // 각 노드(알파벳 A~Z)의 왼쪽, 오른쪽 자식을 저장하는 배열(-1이면 자식 없음)
    static int[] left;
    static int[] right;
    static StringBuilder sb;

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());

        left = new int[26];
        right = new int[26];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        // n개의 줄에 걸쳐 각 노드와 자식 노드 정보 입력받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char lchild = st.nextToken().charAt(0);
            char rchild = st.nextToken().charAt(0);
            int idx = parent - 'A';

            if(lchild != '.') {
                left[idx] = lchild - 'A';
            }
            if(rchild != '.') {
                right[idx] = rchild - 'A';
            }
        }

        // 전위 순회
        sb = new StringBuilder();
        preorder(0);
        sb.append("\n");

        // 중위 순회
        inorder(0);
        sb.append("\n");

        // 후위 순회
        postorder(0);

        return sb.toString();
    }

    // 전위 순회: (루트, 왼쪽, 오른쪽)
    private static void preorder(int node) {
        if (node == -1) return;
        sb.append((char)(node + 'A'));
        preorder(left[node]);
        preorder(right[node]);
    }

    // 중위 순회: (왼쪽, 루트, 오른쪽)
    private static void inorder(int node) {
        if (node == -1) return;
        inorder(left[node]);
        sb.append((char)(node + 'A'));
        inorder(right[node]);
    }

    // 후위 순회: (왼쪽, 오른쪽, 루트)
    private static void postorder(int node) {
        if (node == -1) return;
        postorder(left[node]);
        postorder(right[node]);
        sb.append((char)(node + 'A'));
    }
}
