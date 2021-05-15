// https://leetcode.com/problems/ugly-number-ii/

class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int dp[] = new int[n];
        
        int fac2=2;// given
        int fac3=3;// given
        int fac5=5;// given

        int i2=0;//index of given value
        int i3=0;//index of given value
        int i5=0;//index of given value
        
        
        dp[0]=1;// 2^0 * 3^0 * 5^0 = 1
            
        int k=0;
        for(int i=1; i<n; i++){
            //find min value
            int min = Math.min(fac2, Math.min(fac3, fac5));
            
            //put min value at the end
            dp[i]=min;
            

            //use if if if, to update duplicate values
            if(fac2==min) fac2=dp[++i2]*2;//if ==min update index and fac value
            if(fac3==min) fac3=dp[++i3]*3;//if ==min update index and fac value
            if(fac5==min) fac5=dp[++i5]*5;//if ==min update index and fac value
        }
        return dp[n-1];
    }
}

/*
(0 0 0) (1 0 0) (1 1 0) (2 1 1) ...
(2 3 5) (4 3 5) (4 6 5) (8 6 10) ...
*/