package com.ohgiraffers.section07.heap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Practice2 {

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;

        Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        // 무게 오름차순, 무게가 같으면 가격 내림차순 정렬
        @Override
        public int compareTo(Jewelry o) {
            if (this.weight == o.weight)
                return o.price - this.price;
            return this.weight - o.weight;
        }
    }

    public long solution(String input) {
        String[] inputs = input.split("\n");
        int N = Integer.parseInt(inputs[0].split(" ")[0]);
        int K = Integer.parseInt(inputs[0].split(" ")[1]);
        List<Jewelry> jewelryList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String[] jewelryInput = inputs[i].split(" ");
            int weight = Integer.parseInt(jewelryInput[0]);
            int price = Integer.parseInt(jewelryInput[1]);
            jewelryList.add(new Jewelry(weight, price));
        }

        Integer[] bagArr = new Integer[K];
        for (int i = 0; i < K; i++) {
            bagArr[i] = Integer.valueOf(inputs[i + K + 2]);
        }

        // 가방 오름차순 정렬
        Arrays.sort(bagArr);

        /*
        * 가방 공간이 적은 순으로 정렬하고,
        * 가방에 넣을 수 있는 보석중 제일 가격이 높은 것을 넣는다.
        * */
        int sum = 0;
        for(int bag : bagArr) {
            PriorityQueue<Jewelry> pq = new PriorityQueue<>();
            for(Jewelry jewelry : jewelryList) {
                if (bag >= jewelry.weight) {
                    pq.add(jewelry);
                }
            }

            if (!pq.isEmpty()) {
                sum += pq.peek().price;
                jewelryList.remove(pq.poll());
            }
        }
        return sum;
    }
}