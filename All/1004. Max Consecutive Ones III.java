/*
https://leetcode.com/problems/max-consecutive-ones-iii/
*/

class Solution {
    public int longestOnes(int[] ar, int k) {
        int len=0;//window size
        int z=k;
        int mx=0;
        for(int i=0; i<ar.length; i++){
        	//if curr is 1, increase window size
            if(ar[i]==1){
                len++;
            }
            else{
            	//if we have zeros then increse window size
                if(z>0){
                    z--;
                    len++;
                }
                else{// current is zero and we don't have zero
                	
                    if(ar[i-len]==0){
                    	// check if first element of WINDOW is ==0 then increase z+1;
                        z++;
                    }
                    len--;// remove first element either first element is 0 or 1
                    i--;// re-visit current element
                }
            }
            mx=Math.max(mx, len);
        }
        
        return mx;
    }
}
