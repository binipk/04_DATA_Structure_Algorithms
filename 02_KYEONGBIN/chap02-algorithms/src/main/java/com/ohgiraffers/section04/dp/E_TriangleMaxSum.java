package com.ohgiraffers.section04.dp;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class E_TriangleMaxSum {

    public static int solution(String input) throws Exception {

        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine()); // Number of rows in the triangle

        int[][] t = new int[n + 1][n + 1];   // Array to store the triangle values
        int[][] dp = new int[n + 1][n + 1]; // DP array to store max sum to each position

        // Reading the triangle input
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Initialize the top of the triangle
        dp[1][1] = t[1][1];

        // Debug: Print the triangle
        System.out.println("Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        // Initialize the dp for the first element
        System.out.println("Initial DP[1][1]: " + dp[1][1]);

        // Apply DP: each cell takes the max sum path from above-left or above
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + t[i][j]; // First column, can only come from above
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + t[i][j]; // Last column, can only come from the left diagonal
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + t[i][j]; // Max from top-left or top-right
                }
            }

            // Debug: print DP and Triangle values of current row
            System.out.println("Row " + i + ":");
            System.out.print("Triangle: ");
            for (int j = 1; j <= i; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();

            System.out.print("DP: ");
            for (int j = 1; j <= i; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // Find the maximum value in the last row (final answer)
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[n][i]);
        }

        System.out.println("Final Answer: " + answer);
        return answer;
    }
}
