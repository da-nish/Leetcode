// https://leetcode.com/problems/count-sorted-vowel-strings/
// solution
// https://leetcode.com/problems/count-sorted-vowel-strings/discuss/939122/3-solutions-(with-pictures)
/*

total 5 solution written
check one by one

*/
class Solution {
    public int countVowelStrings(int n) {
        c=0;
        task(0, n);
        return c;
	}

    //solution 1
	static int c=1;
	static public void task(int st, int n){

		if(n==0){ 
            c++;
			return;
		}
		
		for(int i=st; i<5; i++){
			task(i,n-1);
		}
	}

    //solution 2
	//DP-EFFICIENT space - O(n*5) 
	public int countVowelStrings(int n) {
        if(n==0) return 0;
        
        int dp[][] = new int[n][5];
        dp[0][0]=1;
        dp[0][1]=1;
        dp[0][2]=1;
        dp[0][3]=1;
        dp[0][4]=1;

        int sum=5;
        for(int i=1; i<n; i++){
            for(int j=3; j>=0; j--){
                dp[i][j]=dp[i-1][j]+dp[i][j+1];
                sum+=dp[i][j];
            }
        }
        return sum;
        
	}

    //solution 3
    // DP-EFFICIENT space - O(6)  
    public int countVowelStrings(int n) {
        if(n==0) return 0;
        
        int dp[] = new int[6];
        dp[0]=0;
        dp[1]=0;
        dp[2]=0;
        dp[3]=0;
        dp[4]=1;
        dp[5]=0;//extra for handling out of index

        int sum=0;
        for(int i=1; i<=n; i++){
            sum=0;//reset 
            for(int j=4; j>=0; j--){
                dp[j]=dp[j]+dp[j+1]; //previous + current
                sum+=dp[j];//result, or write separate sum loop
            }
        }
        return sum;
    }

    //solution 4
    // DP-EFFICIENT space - O(6)  
    public int countVowelStrings(int n) {
        int dp[] = new int[5];
        dp[0]=0;
        dp[1]=0;
        dp[2]=0;
        dp[3]=0;
        dp[4]=1;

        for(int i=1; i<=n; i++){
            dp[3]+=dp[4];
            dp[2]+=dp[3];
            dp[1]+=dp[2];
            dp[0]+=dp[1];
        }

        int sum = dp[4]+dp[3]+dp[2]+dp[1]+dp[0];
        return sum;
    }

    //solution 5
    //easy and efficient
    public int countVowelStrings(int n) {
        int a=0;
        int e=0;
        int o=0;
        int i=0;
        int u=1;

        // from last to front, u to a 
        while(n!=0){
            i+=u;
            o+=i;
            e+=o;
            a+=e;
            n--;
        }

        int sum = a+e+i+o+u;
        return sum;
    }
}