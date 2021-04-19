import java.util.*;

/*
1738. Find Kth Largest XOR Coordinate Value
https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/submissions/

we have find all combination XOR and return kth largest value
*/

class file{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int ar[][] = {
            {5,2},{1,6}
        };

        System.out.println("result: "+kthLargestValue(ar, 2));
        

    }



    public static int kthLargestValue(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols];
        List<Integer> l = new ArrayList();
        for(int i=0; i<rows; i++){
            int cur = 0;
            for(int j=0; j<cols; j++){
                System.out.print(cur+" "+matrix[i][j]);
                cur ^= matrix[i][j];
                System.out.println(" = "+cur);
                dp[j] = i==0 ? cur : (cur^dp[j]);
                l.add(dp[j]);
            }
        }
        System.out.println("list: "+l);
        Collections.sort(l, Collections.reverseOrder());
        return l.get(k-1);
    }
}