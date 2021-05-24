
// https://leetcode.com/problems/longest-common-subsequence/


class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int n=t1.length();
        int m=t2.length();
        
        int dp[][] = new int[n+1][m+1];
        return lcs(t1,t2,dp); //tabuler
        
        
        // for(int i[]:dp) Arrays.fill(i, -1);
        // return lcs(t1,t2,0,0,dp); //mamoization
    }
    
    public int lcs(String t1, String t2, int n, int m, int dp[][]){
        if(n==t1.length() || m==t2.length()) return 0;
        
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(t1.charAt(n)==t2.charAt(m)){
            dp[n][m] = lcs(t1, t2, n+1, m+1,dp)+1;
            return dp[n][m];
         }
        
        dp[n][m] = Math.max(lcs(t1, t2, n+1, m,dp), lcs(t1, t2, n, m+1,dp));
        return dp[n][m];
    }

    
    //tabuler
    public int lcs(String t1, String t2, int dp[][]){
           
        
        for(int i=1; i<=t1.length(); i++){
            for(int j=1; j<=t2.length(); j++){
                if(t1.charAt(i-1)==t2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[t1.length()][t2.length()];
        
    }
}