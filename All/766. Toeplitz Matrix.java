/*
https://leetcode.com/problems/toeplitz-matrix/submissions/
*/

class Solution {
    public boolean isToeplitzMatrix(int[][] ar) {
        int n=ar.length;
        int m=ar[0].length;
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(ar[i-1][j-1]!=ar[i][j]) return false;
            }
        }
        
        return true;
    }
}