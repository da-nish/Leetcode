// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

/*
Note: find min sub array and max sub array
	
	find max using kadine 
	find min using kadine 
	find max(abs.min, abs.max)

*/
class Solution {
    
    public int maxAbsoluteSum(int[] ar) {
        
        int pre = ar[0];
        int mx = ar[0];
        int n=ar.length;
        
        //max kadine
        for(int i=1; i<n; i++){
            if(ar[i] > pre+ar[i]){
                pre=0;
            }
            pre=pre+ar[i];
            mx=Math.max(mx,pre);
            
        }
        
        //min kadine
        pre=ar[0];
        int mn=ar[0];
        for(int i=1; i<n; i++){
            if(pre+ar[i] > ar[i]){
                pre=0;
            }
            pre=pre+ar[i];
            mn=Math.min(mn,pre);
            
        }
        
        return Math.max(Math.abs(mx), Math.abs(mn));
    }
}