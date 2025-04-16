package com.ohgiraffers.section01.sorting;

import java.util.Arrays;

public class D_QuickSort {

    /* 문제 : n개의 정수가 주어졌을 때, 퀵 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성한다. */


    public static void solution(int[] arr) {
        System.out.println("원본 배열 : " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("정렬된 배열 : " + Arrays.toString(arr));

        Arrays.sort(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return; // 기본 종료 조건

        int partitionIndex = partition(arr, low, high);
        quickSort(arr, low, partitionIndex-1);
        quickSort(arr, partitionIndex, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high)/2];
        System.out.println("피벗 " + pivot + " 기준, 인덱스 범위 : " + low + " ~ " + high);
        System.out.println("분할 전 배열 : " + Arrays.toString(arr));

        while(low <= high) {
            while(arr[low] < pivot) low++;
            while(arr[high] > pivot) high--;

            if(low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }

        System.out.println("분할 후 배열 : " + Arrays.toString(arr));
        System.out.println("반환 할 pivot 인덱스 : " + low);
        System.out.println("------------------------------------------");

        return low;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
