package com.ohgiraffers.section07.heap;

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
            if(this.weight == o.weight)
                return o.price - this.price;
            return this.weight - o.weight;
        }
    }

    public long solution(String input) {
        if (input.length() == 0) {
            return 0;
        } else if (input.charAt(0) == '-') {
            input = input.substring(1);
        }
        return 0;
    }
}