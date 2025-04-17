package com.ohgiraffers.section03.greedy;

import java.util.ArrayList;

public class A_SugarDelivery {
    /*
     * 설탕 배달 문제
     * 매 단계마다 즉각적으로 최적이라고 생각되는 선택을 반복해서
     * 전체 문제의 해답(최소 봉지의 수)를 구하는 문항
     * */

    // 5kg, 3kg
    public static int solution(Integer n) {

        /* 3kg와 5kg로 봉지로 가져갈 수 있는 최소 봉지 수 */
        int count = 0;

        while (true) {
            if(n % 5 == 0) {
                return n / 5 + count;
            } else if( n < 0) { // 3 or 5 조합으로 해결 안되는 상황
                return -1;
            } else if(n == 0) { // 3kg 봉지로만 해결
                return count;
            }
            n = n - 3;
            count++;
        }


        //        if (input < 5) {
//            if (input % 3 == 0) {
//                result = input / 3;
//            }
//
//            return result;
//        }
//
//        for (int i = input / 5; i <= input; i--) {
//            System.out.println(i);
//            int aCnt = input % i;
//
//            if(aCnt == 0) {
//                result = i + 1;
//                break;
//            }
//
//            if (aCnt % 3 == 0) {
//                result = i + 1 + (aCnt / 3);
//                break;
//            }
//        }
//        return result;
    }


}
