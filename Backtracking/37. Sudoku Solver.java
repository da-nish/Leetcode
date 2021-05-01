/*
https://leetcode.com/problems/sudoku-solver/
*/
class Solution {
    public void solveSudoku(char[][] board) {
        doo(board, 0, 0);
		// print(s);        
    }
    public static boolean doo(char s[][], int row, int col){
		if(col==s.length){
			row++;
			col=0;
		}

		if(row==s.length){
			return true;
		}

		if(s[row][col]!='.') {
			return doo(s, row, col+1);
		}

		for(int i=1; i<=9; i++){
			if(s[row][col]!='.') continue;

			char val= (char)(i+48);
			// System.out.println(val);

			if(safe(s, row, col, val)){
				s[row][col] = val;
				//using boolean return to skip other calls after first solution
				if(doo(s, row, col+1)) return true;
				s[row][col] = '.'; 
			}
		}
		return false;
	}

	public static boolean safe(char s[][], int row, int col, char val){

		// horizontal
		for (int i=0; i<9; i++) {
			if(s[row][i]==val) return false;
		}

		// vertical
		for (int i=0; i<9; i++) {
			if(s[i][col]==val) return false;
		}

		row=(row/3)*3;
		col=(col/3)*3;

		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {

				if(s[row+i][col+j]==val) return false;
			}
		}
		return true;
	}

	public static void print(char s[][]){
		for (char s1[]: s ) {
			System.out.println(Arrays.toString(s1));
		}
		System.out.println("---------------------------");
	}
    
}