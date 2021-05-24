/*
https://leetcode.com/problems/coin-change-2/

in tabuler method 
when consider an element then search in current row (dp[i][j]) and 
not consider search in row-1(dp[i-1][j])


*/
class Solution {


    //tabuler
    public int change(int t, int[] ar) {
        int n=ar.length;
        int dp[][] = new int[n+1][t+1];
        
        for(int i=0; i<=n; i++) dp[i][0]=1;
        
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=t; j++){
                
                if(ar[i-1]<=j){//consider+notconsider
                    dp[i][j] = dp[i-1][j] + dp[i][j-ar[i-1]];
                }
                else{//not consider
                    dp[i][j] = dp[i-1][j];

                }
            }
        }
        
        
        int re=dp[n][t];
        // int re = helper(ar, t, n, dp);
        
        return re;
    }
    
    //memoization
    public int helper(int ar[], int t, int i, int dp[][]){
        if(t==0){
            return 1;
        }
        if(i==0) return 0;
        
        if(dp[i][t]!=0) return dp[i][t];
        
        if(ar[i-1]<=t){
            int consider = helper(ar, t-ar[i-1],i,dp);
            int notconsider = helper(ar, t,i-1,dp);
            dp[i][t]= consider+notconsider;
            return dp[i][t];
        }
        else{
            int notconsider = helper(ar, t,i-1,dp);
            dp[i][t]= notconsider;
            return dp[i][t];
        }
        
        
    }
}