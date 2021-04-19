/*
https://leetcode.com/problems/sort-array-by-parity-ii/
*/
class Solution {
    public int[] sortArrayByParityII(int[] ar) {
        
        int n= ar.length;
        
        int i=0;
        int j=1;
        while(i<n && j<n){
            if(ar[i]%2==0) i+=2;
            else if(ar[j]%2!=0) j+=2;
            else{
                int t = ar[i];
                ar[i] = ar[j];
                ar[j] = t;
            }
            
        }
        return ar;
    }
}