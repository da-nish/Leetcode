// https://leetcode.com/problems/coin-change/
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int dp[][] = new int[coins.length+1][amount+1];
        
        int re = helper(coins, amount, coins.length-1,dp);
        return re==100?-1:re;
    }
    
    //recursion+memoization
    public int helper(int ar[], int target, int i, int dp[][]){
        if(target==0) return 0;
        if(i<0) return 100;
        
        if(dp[i][target]!=0) return dp[i][target];
        
        if(ar[i]<=target){
            int consider = helper(ar, target-ar[i], i, dp);
            int notconsider = helper(ar, target, i-1, dp);

            //+1 consider
            dp[i][target] = Math.min(consider+1, notconsider);
            return dp[i][target];
        }
        else{
            int notconsider = helper(ar, target, i-1, dp);
            dp[i][target] = notconsider;
            return dp[i][target];
        }  
    }
}