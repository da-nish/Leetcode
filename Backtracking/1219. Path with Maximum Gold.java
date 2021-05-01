/*
https://leetcode.com/problems/path-with-maximum-gold/
*/

class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visit[][] = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0) visit[i][j] = true;
            }
        }
        max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(grid[i][j]!=0) doo(grid, visit, i,j, 0);
            }
        }
        
        return max;
        
    }
    
    static int max=0;
    static void doo(int ar[][], boolean visit[][], int row, int col, int sum){
        max = Math.max(max, sum);
        if(row>=ar.length || col>=ar[0].length) return;
        if(row<0 || col<0) return;
        if(visit[row][col]) return;        
        
        
        sum+=ar[row][col];
        visit[row][col] = true;
        
        // down
        doo(ar, visit, row-1, col, sum);

        // top
        doo(ar, visit, row+1, col, sum);
        
        // right
        doo(ar, visit, row, col+1, sum);
        
        // left
        doo(ar, visit, row, col-1, sum);
     
        visit[row][col] = false;
    }
}