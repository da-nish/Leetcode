/*
https://leetcode.com/problems/minimum-path-sum/
*/
class Solution {
    public int minPathSum(int[][] ar) {
        
        for(int i=1; i<ar[0].length;i++) ar[0][i]+=ar[0][i-1];
        for(int i=1; i<ar.length;i++) ar[i][0]+=ar[i-1][0];
        
        for(int i=1; i<ar.length; i++){
            for(int j=1; j<ar[0].length; j++){
                ar[i][j] = ar[i][j]+ Math.min(ar[i][j-1], ar[i-1][j]);
            }
        }
        
        return ar[ar.length-1][ar[0].length-1];
    }
}