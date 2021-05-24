/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
class Solution {
    public int maxProfit(int[] ar) {
        
        int stock=999999;
        int profit=0;


        for(int i=0; i<ar.length; i++){
            stock = Math.min(ar[i],stock); //minimum till now
            profit = Math.max(profit, ar[i] - stock); //find max profit with min value
        }
        return profit;
    }
}