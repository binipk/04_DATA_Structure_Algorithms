package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class C_MeetingRoomScheduler {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int N = Integer.parseInt(br.readLine());  // 회의의 갯수
        int[][] time = new int[N][2];  // 회의 갯수 * (시작시간/종료시간)
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        /* 기본적인 조건은 종료시간이 빠른 회의 순서로 데이터 정렬 */
        Arrays.sort(time, (t1, t2) -> {
            if(t1[1] == t2[1]) return t1[0] - t2[0];
            return t1[1] - t2[1];
        });

        int endTime = 0;            // 직전 회의가 끝난 시간을 담아둘 변수
        int count = 0;              // 회의가 배정된 개수

        /* time 배열 안에 있는 회의를 반복하며 회의 시간표에 넣을지 확인 */
        for (int i = 0; i < N; i++) {
            if(time[i][0] >= endTime) {
                count++;
                endTime = time[i][1];  // 이후 회의 확인을 위해 종료 시간 수정
            }
        }

        return count;


        // ** 직접짠 코드는 시간 초과 걸림 **
//        BufferedReader br = new BufferedReader(new StringReader(input));
//        int N = Integer.parseInt(br.readLine()); // 회의 개수
//        int[][] time = new int[N][2];
//        StringTokenizer st;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            time[i][0] = Integer.parseInt(st.nextToken());
//            time[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(time, Comparator.comparingInt(o -> o[0])); // 회의 시작 시간순으로 정렬
//
//        int end = 0; // 시작 인덱스
//        int maxCnt = 0; // 최대 회의수
//        for (int i = 0; i < time.length; i++) {
//            int cnt = 0;
//            for (int j = i; j < time.length; j++) {
//                if (end <= time[j][0]) { // (전)회의끝난시간보다 (현)회의시작시간이 클 경우
//                    cnt++; // 미팅수 추가
//                    end = time[j][1]; // 회의끝나는 시간 업데이트
//                }
//            }
//            maxCnt = Math.max(maxCnt, cnt);
//            end = 0;
//        }
//
//        return maxCnt;
    }
}