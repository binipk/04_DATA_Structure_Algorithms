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

        return 0;
    }
}
