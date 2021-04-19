/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/

class Solution {
    public int[] twoSum(int[] ar, int k) {
        
        int n=ar.length;
        int j=n-1;
        int i=0;
        int re[] = {i, j};
        while(i<j){
            if(ar[i]+ar[j]==k){
                re[0] = i+1;
                re[1] = j+1;
                return re;
            }else if(ar[i]+ar[j]>k){
                j--;
            }else{
                i++;
            }
        }
        return re;
        
    }
}