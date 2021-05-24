/*
https://leetcode.com/problems/generate-parentheses/

this question can be done using catalan
in this question, return form braket strings, catalan can't form string but it can give count, so don't use
but when we want to count use this approach
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        doo(list, "", n, n);
        return list;
    }
    
    //when we need to count possible arrengement
    public static int catalan(int N){
        int dp[] = new int[N+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<=N; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[N];
    }

    //recursion to find valid bracket string 
    public static void doo(List<String> list, String re,int left, int right){
        if(left==0 && right==0) {
            list.add(re);
            return;
        }
        if(left>right) return;
        
        if(left>0) doo(list, re+'(', left-1,  right);
        if(right>0) doo(list, re+')', left,  right-1);
        
    }
}