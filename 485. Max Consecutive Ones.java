/*
https://leetcode.com/problems/max-consecutive-ones/
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] ar) {
        int n=ar.length;
        
        int m = 0;
        int sum=0;
        for(int i=0; i<n; i++){
            
            if(ar[i]==1){
                sum+=1;
                m = Math.max(m, sum);
            }else{
                sum=0;
            }
        }
        return m;
    }
}