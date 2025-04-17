package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
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
    }
}
