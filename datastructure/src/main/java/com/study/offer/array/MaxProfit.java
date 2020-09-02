package com.study.offer.array;

/**
 * @author hangwu
 * @date 2020/9/1 9:30
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int maxNumber = (int) Math.pow(10, 1);

        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] param = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(param));
    }
}
