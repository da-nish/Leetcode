/*
1476. Subrectangle Queries
https://leetcode.com/problems/subrectangle-queries/
*/


class SubrectangleQueries {
    
    int ar[][];

    public SubrectangleQueries(int[][] rectangle) {
        this.ar = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int val) {
        
        int n=ar.length;
        int m=ar[0].length;
        
        if(row1 >= n || row1<0) return;
        if(row2 >= n || row2<0) return;
        if(col1 >= m || col1<0) return;
        if(col2 >= m || col2<0) return;
        
        for(int i=row1; i<=row2; i++){
            for(int j=col1; j<=col2; j++){
                ar[i][j] = val;
            }
        }
        
    }
    
    public int getValue(int row, int col) {
        return ar[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */