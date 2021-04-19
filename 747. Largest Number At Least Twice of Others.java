/*
https://leetcode.com/problems/largest-number-at-least-twice-of-others/
*/

class Solution {
    public int dominantIndex(int[] ar) {
        
        int n=ar.length;
        
        int ind = 0;
        
        for(int i=0; i<n; i++){
            if(ar[i]>ar[ind]) ind = i;
        }
        int re =0;
        for(int i=0; i<n; i++){
            if(ar[i]+ar[i]>ar[ind] && ind!=i) return -1;
        }
        return ind;
    }
}