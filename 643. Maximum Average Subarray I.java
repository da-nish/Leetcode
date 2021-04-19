/*
https://leetcode.com/problems/maximum-average-subarray-i/
*/
class Solution {
    public double findMaxAverage(int[] ar, int k) {
        
        double re = Double.MIN_VALUE;
        int n = ar.length;
        double sum = 0;
        for(int i=0; i<k; i++){
            sum+=ar[i];
        }
        
        re = sum;
            
        for(int i=k; i<n; i++){
            sum = sum+ar[i]-ar[i-k];
            if(re<sum) re = sum;
        }
        
        return re/k;
    }
}