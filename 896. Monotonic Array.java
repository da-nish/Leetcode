/*
https://leetcode.com/problems/monotonic-array/solution/
*/

class Solution {
    public boolean isMonotonic(int[] A) {
        int n=A.length;
        boolean re = true;
        for(int i=1; i<n; i++){
            if(A[i] >= A[i-1]){}
            else re = false;
        }
        
        boolean re1 = true;
        for(int i=1; i<n; i++){
            if(A[i] <= A[i-1]){}
            else re1 = false;
        }
        
        return re||re1;
        
    }
}