package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice1 {

    static class Balloon {
        int order;
        int noteValue;
        int[] notes = new int[order];

        Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }

    public String solution(Integer[] notes) {
        Deque<Balloon> balloons = new ArrayDeque<>();
        balloons.push(new Balloon(5, 3));

        return null;
    }
}
