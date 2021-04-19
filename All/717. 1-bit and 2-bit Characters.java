/*
https://leetcode.com/problems/1-bit-and-2-bit-characters/
*/
class Solution {
    public boolean isOneBitCharacter(int[] bit) {
        int n = bit.length;
        
        if(n==1) return bit[0]==0;
        if(n==2) return bit[0]+bit[1]==0;
        

        int i=0;
        boolean re = true; 
        while(i<n){
            
            if(bit[i]==1){
                i+=2;
                re = false;
            }
            else{
                i+=1;
                re = true;
            }
            
        }
        
        return re;
    }
}