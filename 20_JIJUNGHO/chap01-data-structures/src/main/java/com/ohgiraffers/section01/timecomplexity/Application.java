package com.ohgiraffers.section01.timecomplexity;

/* 시간 복잡도 : 코드(알고리즘)가 실행되는데 걸리는 시간을 입력 크기(n)에 따라 추정하는 것
* */

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 15, 4, 9, 10, 7};
        // 상수시간 예시 출력
        System.out.println(getFirst(arr));
        // 로그시간 예시 출력
        System.out.println(binarySearch(arr, 1));
        // 선형시간 예시 출력
        System.out.println(Arrays.toString(reverse(arr)));
        // 지수시간 예시 출력
        System.out.println(finbonacci(1000));
    }

    /* 상수시간 O(1) : 입력의 크기와 상관없이, 실행 시간이 변하지 않는 연산 */
    private static int getFirst(int[] arr) {
        return arr[0];
    }

    /* 로그시간 O(log n) : 문제를 매번 절반씩 줄여가며 해결하는 방식 */
    private static int binarySearch(int[] arr, int target) {

        /* 초기세팅(배열을 오름차순으로 정렬)
         * 내부적으로 nlogn 만큼의 시간이 걸리지만 지금은 제외
         * */
        Arrays.sort(arr);

        // 배열의 처음과 끝을 지정하는 인덱스를 담은 변수 (포인터)
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            // 0 + (6-0) / 2 = 3
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /* 선형시간 O(n) : 입력 크기만큼 단순 반복하는 구조 */
    private static int[] reverse(int[] arr) {

        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }

        return reversed;

    }

    /* 지수시간 O(2^n) : 입력이 1 증가할 때마다 연산이 2배 */
    public static int finbonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return finbonacci(n - 1) + finbonacci(n - 2);

    }

}
