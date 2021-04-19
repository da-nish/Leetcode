/*
https://leetcode.com/problems/min-cost-climbing-stairs/
*/

class Solution {
    public int minCostClimbingStairs(int[] ar) {
        
        int n=ar.length;
        
        for(int i=2; i<n; i++){
            ar[i] = ar[i] + Math.min(ar[i-1], ar[i-2]);
        }
        
        return Math.min(ar[n-1], ar[n-2]); // IMP, ( if n==2 ) and [0,0,0,1] case
    }
}