/*
https://leetcode.com/problems/can-place-flowers/
*/

class Solution {
    public boolean canPlaceFlowers(int[] ar, int n) {
        
        if(n==0) return true;
        
        int p=0;
        boolean last = true;
        int len = ar.length;
        
        for(int i=0; i<len-1; i++){
            
            if(ar[i]==0){
                if(last && ar[i+1]==0) {p++; last = false;}
                else last = true;
            }else{
                last = false;
            }
        }
        
        if(last && ar[len-1]==0) p++;
        
        if(p>=n) return true;
        return false;
        
    }
}