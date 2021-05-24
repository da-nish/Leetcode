// https://leetcode.com/problems/target-sum/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int res = doo(nums, target,0,0);
        return res;
        
    }
    
    
    public int doo(int ar[], int t, int re, int i){
        if(t==re && i==ar.length){ 
            // res++;
            return 1;
        }
        if(i==ar.length) return 0;
        
        int add = doo(ar, t, re+ar[i], i+1);
        int sub = doo(ar, t, re-ar[i], i+1);
   
        return add+sub;
    }
}