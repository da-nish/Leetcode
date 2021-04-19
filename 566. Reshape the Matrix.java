
/*
https://leetcode.com/problems/reshape-the-matrix/
*/
class Solution {
    public int[][] matrixReshape(int[][] ar, int r, int c) {
        
        int n = ar.length;
        int m = ar[0].length;
 
        if(n*m!=r*c) return ar;
        
        int mt[][] = new int[r][c];
        
        int tr = 0;
        int tc = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                mt[tr][tc++] = ar[i][j];
                if(tc==c){
                    tr++; tc=0;  
                } 
                
            }
        }
        return mt;
            
    }
}