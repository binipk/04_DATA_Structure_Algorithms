package com.ohgiraffers.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_selectionSort {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int length = Integer.parseInt(br.readLine());

            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 선택 정렬 수행
            solution(length, arr);

            // 결과 출력
            for (int num : arr) {
                System.out.print(num + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 선택 정렬 (내림차순)
    public static void solution(int length, int[] arr) {
        for (int i = 0; i < length - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
}
