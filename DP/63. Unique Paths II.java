/*
https://leetcode.com/problems/unique-paths-ii/

Note

Approach 1: Takes N space
    create copy array 
    
    preprocess
        assign obsticle = 0 //in copy array
        assign first row = 1 //in copy array
        assign first col = 0 //in copy array

    iterate in the main array 
    if(element==1)//obsticle
        copyar[][] = 0

    else 
        copyar[][] = left+top of copyarray

Approach 2: O(1) space

    //in given input obsticle are = 1

    preprocess
        assign obsticle = 0;
        assign first row= 1;
        assign first col= 1;

    iterate in the array
    if(element==1)//obsticle
        ar[][] = 0

    else 
        ar[][] = left+top

    preprocess task of this approach is tricky

    when you find first obsticle set all next as obsticle (in both row and col case)

    imp, [0][0] do not precess this index twice
    

    when you find obsticle and number of col==1 OR number of row==1, return 0;


*/

class Solution {
    public int uniquePathsWithObstacles(int[][] ar) {
        int n=ar.length;
        int m=ar[0].length;
        // if(n==1 && m==1) return 1; 


        boolean fl=false;//using boolean to know first obticle

        for(int i=0; i<n; i++){

            if(ar[i][0]==1 || fl){
                ar[i][0]=0;
                fl=true; // all next element set as obsticle
                if(n==1) return 0;
                //when number row==1, there is only way to reach end and there exist obsticle so return 0
            }
            else ar[i][0]=1;
        }

        fl=false;
        //before obs=1 and el=0 
        //after obs=0 and el=1 
        //if first element was set obsticle then set all next obsticle
        if(ar[0][0]==0) fl=true;

        for(int i=1; i<m; i++){
            if(ar[0][i]==1 || fl){
                ar[0][i]=0;
                fl=true;
                if(m==1) return 0;
                //when number col==1, there is only way to reach end and there exist obsticle so return 0

            }
            else ar[0][i]=1;
        }
        
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(ar[i][j]==1){ 
                    ar[i][j]=0;
                }else {
                    ar[i][j]=ar[i-1][j]+ar[i][j-1];
                }
            }
        }
        
        // for(int i[]: ar) System.out.println(Arrays.toString(i));
        
        return ar[n-1][m-1];
    }
}