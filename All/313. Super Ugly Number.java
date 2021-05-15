// https://leetcode.com/problems/super-ugly-number/
/*

it is varient of https://leetcode.com/problems/ugly-number-ii/

*/
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        
        int dp[] = new int[n];
        dp[0]=1;
        
        int fac[]= new int[primes.length];
        int ind[]= new int[primes.length];
    
        for(int i=0; i<primes.length; i++) fac[i]=primes[i];
        
        for(int i=1; i<n; i++){
            
            int min=Integer.MAX_VALUE;
            int m=0;
            //finding min
            for(int j=0; j<fac.length; j++){
                if(min>fac[j]){
                    min=fac[j];
                    m=j;
                }
            }

            dp[i]=fac[m];

            //updating all valus equal to min
            //when duplicate occure in fac array 
            for(int j=0; j<fac.length; j++){
                if(fac[j]==min){
                    fac[j] = dp[++ind[j]]*primes[j];
                }
            }
                
        }
            
        return dp[n-1];
        
    }
}