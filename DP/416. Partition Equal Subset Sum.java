// https://leetcode.com/problems/partition-equal-subset-sum/
/*
Note: convert this problem to subsetsum

    find sum and calculate target=sum/2;
    apply subsetsum

*/

class Solution {
    public boolean canPartition(int[] ar) {
        int n=ar.length;
        int sum=0;
        
        // find sum, if odd return false
        for(int i:ar) sum+=i;
        if(sum%2!=0) return false;


        // 
        int target = sum/2;
        int dp[][] = new int[n+1][(target)+1];
        
        return doo(ar,0,target,dp);
        
    }
    
    //memoization
    public boolean doo(int ar[], int i, int t, int dp[][]){
        //dp[][] is integer type, when result is false set -1 and set 1 for true
        if(t==0) return true;
        if(i==ar.length) return false;

        //considering 0 is default not been processed
        if(dp[i][t]!=0){
            if(dp[i][t]>0) return true;
            else return false;
        }
        
        if(ar[i]<=t){
            boolean re = doo(ar, i+1, t-ar[i],dp) || doo(ar, i+1, t,dp);
            if(re) dp[i][t]=1;
            else dp[i][t]=-1;
            return re;

        }
        else{
            boolean re = doo(ar,i+1, t,dp);
            if(re) dp[i][t]=1;
            else dp[i][t]=-1;
            return re;
        }
    } 

    //tabulation
    public boolean canPartition(int[] ar) {
        int n=ar.length;
        int sum=0;
        
        for(int i:ar) sum+=i;
        if(sum%2!=0) return false;
        int target=sum/2;
        
        boolean dp[][] = new boolean[n+1][(sum/2)+1];
        
        for(int i=0; i<n; i++) dp[i][0]=true;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=target; j++){
                if(ar[i-1]<=j){
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-ar[i-1]];
                    //not consider: copy value from i-1 row because ith element is not consider 
                    //consider: search in i-1 row 
                    // dp[i-1][.] to use only once
                    // dp[i][.] to use multiple time
                }
                else{
                    dp[i][j]= dp[i-1][j];

                }
            }
        }
        return dp[n][target];
    }
}