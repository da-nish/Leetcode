/*
https://leetcode.com/problems/search-a-2d-matrix-ii/
*/

class Solution {
    public boolean searchMatrix(int[][] ar, int t) {
        int n=ar.length;
        int m=ar[0].length;
        for(int i=0; i<n; i++){
            
            int j=0;
            while(j<m){
            	//if == return
                if(t==ar[i][j]) return true;
                //if t< then search in next row
                else if(t<ar[i][j]) j=m+1;
                //if t> keep search in current
                else j++;
            }               
        }
        return false;
    }
}