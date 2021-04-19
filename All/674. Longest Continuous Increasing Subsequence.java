/*
https://leetcode.com/problems/longest-continuous-increasing-subsequence/
*/

class Solution {
    public int findLengthOfLCIS(int[] ar) {
        
        int n = ar.length;
        if(n==0) return 0;
        if(n==1) return 1;
        
        int m = 1;
        int pre = ar[0];
        int c = 1;
        
        for(int i=1; i<n; i++){
            if(ar[i]>pre) m = Math.max(++c,m);
            else c=1;
            pre = ar[i];
        }
        return m;
    }
}