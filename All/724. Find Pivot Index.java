/*
https://leetcode.com/problems/find-pivot-index/
*/


class Solution {
    public int pivotIndex(int[] ar) {
        int n=ar.length;
        if(n==0) return 0;
        
        int left = 0;
        int right = 0;
        
        int sum = 0;
        for(int i: ar) sum+=i;
        
        right = sum;
        for(int i=0; i<n; i++){
            right = right - ar[i];
            if(left == right) return i;
            
            left = left + ar[i];
        }
        
        return -1;
    }
}