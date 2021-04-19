/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/

class Solution {
    public int maxProfit(int[] ar) {
        int n=ar.length;
        int i=0;
        int buy = 0;
        int sell = 0;
        int re=0;
        while(i<n-1){//imp
            while(i < n-1 && ar[i]>=ar[i+1]) i++;
            buy = ar[i];
            while(i < n-1 && ar[i]<=ar[i+1]) i++;
            
            sell = ar[i];
            
            re += sell - buy;
        }
        return re;
        
        
    }
}