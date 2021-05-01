/*
https://leetcode.com/problems/valid-sudoku/
*/

class Solution {
    public boolean isValidSudoku(char[][] b) {
        
        
        
        for(int i=0; i<9; i++){
            if(hori(b,i)==false) return false;
            if(vert(b,i)==false) return false;
        }
        
        if(box(b,0,0)==false) return false;
        if(box(b,0,3)==false) return false;
        if(box(b,0,6)==false) return false;
        
        if(box(b,3,0)==false) return false;
        if(box(b,3,3)==false) return false;
        if(box(b,3,6)==false) return false;
        
        if(box(b,6,0)==false) return false;
        if(box(b,6,3)==false) return false;
        if(box(b,6,6)==false) return false;
        return true;
        
    }
    
    public static boolean box(char[][] b, int row, int col){
        
        Set<Character> set = new HashSet<>();
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(b[i+row][j+col]=='.'){}
                else if(set.contains(b[i+row][j+col])) return false;
                else set.add(b[i+row][j+col]);
            }
        }
        return true;
    }
    
    public static boolean hori(char b[][], int row){
        
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++){
            if(b[row][i]=='.'){}
            else if(set.contains(b[row][i])) return false;
            else set.add(b[row][i]);
        }
        return true;
        
    }
    
    public static boolean vert(char b[][], int col){
        
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++){
            if(b[i][col]=='.'){}
            else if(set.contains(b[i][col])) return false;
            else set.add(b[i][col]);
        }
        return true;
        
    }
    
    
}