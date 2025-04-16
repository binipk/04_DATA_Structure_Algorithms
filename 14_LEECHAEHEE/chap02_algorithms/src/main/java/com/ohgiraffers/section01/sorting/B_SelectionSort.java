package com.ohgiraffers.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/* 선택 정렬
 * 배열에서 최소값을 찾아 맨 앞과 교환하는 방식의 정렬이다.
 * 배열을 여러 번 반복하면서, 선택한 요소와 나머지 요소들을 비교하여 정렬한다.
 * 시간 복잡도는 O(n^2)이며, 정렬을 수행하는 과정에서 교환 횟수가 적은 편이다.
 * 하지만 정렬이 어느 정도 되어 있어도 시간 복잡도는 변하지 않아 비효율적이다.
 * */
public class B_SelectionSort {

    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 선택 정렬 알고리즘을 사용하여 내림차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *    - 내림차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     * 설명.
     *  예시 입력 1
     *    - 10
     *      32 7 34 39 40 41 22 31 23 25
     *  예시 출력 1
     *    - 41 40 39 34 32 31 25 23 22 7
     *
     * 설명.
     *  예시 입력 2
     *    - 6
     *      42 29 34 64 28 12
     *  예시 출력 2
     *    - 64 42 34 29 28 12
     * */

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int length = Integer.parseInt(br.readLine());

            IntStream intStream = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x));
            int[] arr = intStream.toArray();

            // 알고리즘 실행
            solution(length, arr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solution(int length, int[] arr) {

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.println((i + 1) + "번째 : " + Arrays.toString(arr));
            int maxIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // 선택 된 데이터(최대값)가 들어가야할 인덱스로 교환
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
}