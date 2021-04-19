import java.util.*;
/*
https://leetcode.com/problems/transpose-matrix/submissions/
*/

class Solution {
    public int[][] transpose(int[][] ar){
       int n=ar.length;
        int m=ar[0].length;
        
        int mt[][] = new int[m][n];
        
        for(int i=0; i<m; i++){
            for( int j=0; j<n; j++){
            mt[i][j] = ar[j][i];
            }
        }
        return mt;
    }
}