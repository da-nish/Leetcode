/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/





*/

class Solution {

    //approach 1
    public int maxProfit(int[] ar) {
        int n=ar.length;
        int i=0;
        int re=0;
        while(i<n-1){//imp
            
            //skip adjecent values and find next first lesser value
            while(i < n-1 && ar[i]>=ar[i+1]){
                i++;
            }
            //buy on lesser value
            int buy = ar[i];
            //skip adjecent value and find last greater adjecent value
            while(i < n-1 && ar[i]<=ar[i+1]){
                i++;
            }

            int sell = ar[i];
            re += sell - buy;
        }
        return re;
    }
    
    //approach 2 - efficient
    public int maxProfit(int[] ar) { 
        int sum=0;

        for(int i=1; i<ar.length; i++){ 
            //there is profit when current is greater than prevous;
            if(ar[i]>ar[i-1]){
                sum+=ar[i]-ar[i-1];
            }    
        }
        
        return sum;
    }
}