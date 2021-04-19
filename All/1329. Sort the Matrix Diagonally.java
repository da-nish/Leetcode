import java.util.*;
/*

https://leetcode.com/problems/sort-the-matrix-diagonally/

*/
class file{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int ar[][] = {
			{3,3,1,1},
			{2,2,1,2},
			{1,1,1,2}
		};

		int mat[][] = diagonalSort(ar);

		for(int i[]: mat)
			System.out.println(Arrays.toString(i));

	}

    public static int[][] diagonalSort(int[][] ar) {
        
        
        int n=ar.length;
        int m=ar[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(map.containsKey(i-j)){
                   map.get(i-j).add(ar[i][j]);
               }
                else{
                    map.put(i-j, new PriorityQueue<>());
                   map.get(i-j).add(ar[i][j]);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               ar[i][j] = (map.get(i-j)).remove();
            }
        }
        
        
        return ar;
        
    }
}