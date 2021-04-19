/*
https://leetcode.com/problems/missing-number/

solution: sort and find missing no.

*/

class Solution {
    public int missingNumber(int[] ar) {
        int n = ar.length;
        int sum=0;
        int expacted_total = n*(n+1)/2;
        
        for(int i:ar) sum+=i;
        
        return expacted_total-sum;
    }
    
}