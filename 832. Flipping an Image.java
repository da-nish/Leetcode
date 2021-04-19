
import java.util.*;


/*
https://leetcode.com/problems/flipping-an-image/
*/
class file{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int ar[][] = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};

        

        flipAndInvertImage(ar);

        for (int i[]: ar) {
            System.out.println(Arrays.toString(i));
        }
    }


    public static int[][] flipAndInvertImage(int[][] ar) {
        
        int n=ar.length;
        int m=ar[0].length;
        
        
        for(int i=0; i<n; i++){
            doo(ar[i], m);
        }
        return ar;
    }
    
    
    public static void doo(int ar[], int m){
        int x=0;
        
        for(int i=0; i<(m+1)/2; i++){
            int t=ar[i];
            ar[i] = ar[m-1-i];
            ar[m-1-i] = t;

        }
        for(int i=0; i<m; i++) ar[i] = ar[i]==1?0:1;
        

    }
}