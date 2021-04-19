/*
https://leetcode.com/problems/maximum-product-of-three-numbers/
*/
/*
efficient solution: 
	run loop and find 2 min elements and 3 max element 
*/

class Solution {
    public int maximumProduct(int[] ar) {
        
        Arrays.sort(ar);
        int n = ar.length;
        if(n==3) return ar[0]*ar[1]*ar[2];
        
        
        int mx = Integer.MIN_VALUE;
        
        mx = Math.max(mx, ar[0]*ar[1]*ar[n-1]);
        mx = Math.max(mx, ar[0]*ar[n-2]*ar[n-1]);
        mx = Math.max(mx, ar[n-3]*ar[n-2]*ar[n-1]);
        
        return mx;
    }
}