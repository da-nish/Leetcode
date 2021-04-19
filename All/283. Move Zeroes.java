/*
https://leetcode.com/problems/move-zeroes/
*/

class Solution {
    public void moveZeroes(int[] ar) {
        
        int n=ar.length;
        int i=0;
        while(i<n && ar[i]!=0) i++;
        int j=i;
        while(j<n &&ar[j]==0) j++;
        
        while(i<n && j<n){
            if(ar[j]==0) j++;
            else if(ar[i]!=0) i++;
            
            else if(ar[i]==0 && ar[j]!=0){
                int t = ar[i];
                ar[i] = ar[j];
                ar[j] = t;
            }
            
        }
    }
}


//efficient
class Solution {
    public void moveZeroes(int[] ar) {
        
        int n=ar.length;
        
        //shifting non-zero values
        int zero=0;
        for(int i=0; i<n; i++){
            
            if(ar[i]==0) zero++;
            else{
                ar[i-zero] = ar[i];
            }
        }
        
        //putting zero
        while(zero>0){
            ar[--n] = 0;
            zero--;
        }
    }
}