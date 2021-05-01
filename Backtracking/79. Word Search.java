/*
https://leetcode.com/problems/word-search/
*/

class Solution {
    public boolean exist(char[][] b, String s) {
        re=false;
        doo(b,s,0,0,0);
        return re;
    }
    static boolean re=false;
    
    public static void doo(char b[][], String s, int row, int col, int d){
        //positive bc
        if(d==s.length()) {
            re=true;
            return;
        }

        //negative bc
        if(row==b.length || row<0) return; 
        if(col==b[0].length || col<0) return;

        //this element already used
        if(s.charAt(d)=='.') return;

        //after matching some element, and current is not matching
        if(d>0 && s.charAt(d)!=b[row][col]) return;
        
        if(s.charAt(d)==b[row][col]){
            //using element 
            b[row][col]='.';

            //left
            doo(b,s,row,col-1,d+1);
            //right
            doo(b,s,row,col+1,d+1);
            //top
            doo(b,s,row-1,col,d+1);
            //down
            doo(b,s,row+1,col,d+1);
            
            //removing element
            b[row][col]=s.charAt(d);
            
            //when d>0 means some elements are found then do not call Not-consider 
            if(d>0)return;
        }
        
            //Not consider
            if(col+1==b[0].length)
                 doo(b,s,row+1,0,0);
            
            else
                doo(b,s,row,col+1,0);
        
        }
}