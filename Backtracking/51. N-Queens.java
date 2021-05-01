import java.util.*;
/*
https://leetcode.com/problems/n-queens/
*/
class file{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        solveNQueens(1);

    }
// List<List<String>>
    static public void solveNQueens(int n) {

        re=0;
        doo(new int[n][n], 0, 0, n);
        System.out.println(re);
    }
    static int re=0;
    
    
    public static void doo(int ar[][], int row, int col, int queen){
        if(queen==0) {
            // print(ar);
            re++;
            return;
        }
        if(col==ar[0].length){
            col=0;
            row++;
        }
        if(row==ar.length)
            return;
        
        for(int i=0; i<ar[0].length; i++){
            if(ar[row][i] ==0 && issafe(ar, row, i)){
                ar[row][i] = 1;

                doo(ar, row+1, 0 , queen-1);
                ar[row][i] = 0;
                
            }
        }
    }
    
    
    public static boolean issafe(int ar[][], int row, int col){
        int i=row-1;
        int j=col;

        
        //top
        while(i>=0){
            if(ar[i][j]==1) return false;
            i--;
        }
        
        i=row;
        j=col-1;
        //left
        while(j>=0){
            if(ar[i][j]==1) return false;
            j--;
        }
        
        i=row-1;
        j=col-1;
        //top-left
        while(j>=0 && i>=0){
            if(ar[i][j]==1) return false;
            j--;
            i--;
        }
        
        i=row-1;
        j=col+1;
        //top-right
        while(j<ar[0].length && i>=0){
            if(ar[i][j]==1) return false;
            j++;
            i--;
        }
        
        return true;
           
    }


    public static void print(int ar[][]){
        for (int a[]: ar ) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("--------------------------");
    }
}